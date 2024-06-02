package com.example.dhiwisepracticaltask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.dhiwisepracticaltask.R
import com.example.dhiwisepracticaltask.databinding.ActivityHomeBinding
import com.example.dhiwisepracticaltask.model.ApiStatus
import com.example.dhiwisepracticaltask.model.FigmaFileResponse
import com.example.dhiwisepracticaltask.utils.DataLoadingDialog
import com.example.dhiwisepracticaltask.utils.FOLDER_NAME
import com.example.dhiwisepracticaltask.utils.JSON_RESPONSE_FILE_NAME
import com.example.dhiwisepracticaltask.utils.backgroundScope
import com.example.dhiwisepracticaltask.utils.checkJSONFileExitsOrNot
import com.example.dhiwisepracticaltask.utils.extractedFileIdFromFigmaLink
import com.example.dhiwisepracticaltask.utils.loadJSONFromFile
import com.example.dhiwisepracticaltask.utils.saveFigmaFileResponseToFile
import com.example.dhiwisepracticaltask.utils.toastMsg
import com.example.dhiwisepracticaltask.viewmodel.FigmaViewModel
import com.google.gson.Gson
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.w3c.dom.Node
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class HomeActivity : AppCompatActivity() {

    private var _binding: ActivityHomeBinding? = null
    private val figmaViewModel: FigmaViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        initSetup()
        allClicks()
    }

    private fun initSetup() {
        _binding?.apply {
            toolbar.toolbarTitle.text = resources.getString(R.string.app_name)
            identifyJsonButton.isVisible = checkJSONFileExitsOrNot()
        }
    }

    private fun allClicks() {
        _binding?.apply {
            submitButton.setOnClickListener {
                val figmaLink = figmaLinkEditText.text.toString()
                val figmaToken = figmaTokenEditText.text.toString()
                when {
                    figmaLink.isEmpty() -> {
                        toastMsg(resources.getString(R.string.figma_link_not_attached))
                    }

                    figmaToken.isEmpty() -> {
                        toastMsg(resources.getString(R.string.figma_token_not_attached))
                    }

                    figmaLink.isNotEmpty() && figmaToken.isNotEmpty() -> {
                        apiCall(
                            fileId = extractedFileIdFromFigmaLink(figmaLink) ?: "",
                            token = figmaToken
                        )
                    }
                }
            }

            identifyJsonButton.setOnClickListener {
                if (checkJSONFileExitsOrNot()) {
                    val jsonFile = loadJSONFromFile(JSON_RESPONSE_FILE_NAME)
                    Log.e("JASH", "identifyJsonButton:----${jsonFile}")
                    jsonFile?.let {
                        val components = it.getJSONObject("components")
                        val document = it.getJSONObject("document")
                        traverseDocument(document, components)
                    }
                } else {
                    toastMsg(resources.getString(R.string.file_not_found))
                }
            }
        }
    }

    private fun traverseDocument(document: JSONObject, components: JSONObject) {
        val children = document.getJSONArray("children")
        backgroundScope.launch {
            for (i in 0 until children.length()) {
                val child = children.getJSONObject(i)
                processNode(child, components)
            }
        }
    }

    private fun processNode(node: JSONObject, components: JSONObject) {
        val nodeId = node.getString("id")
        val nodeType = node.getString("type")
        val componentName = components.optJSONObject(nodeId)?.getString("name")
        when (nodeType) {
            "TEXT" -> println("Found Text: $componentName")
            "RECTANGLE" -> println("Found Button: $componentName")
            "IMAGE" -> println("Found Image: $componentName")
            "Input:EditText" -> println("Found EditText: $componentName")
        }

        Log.e("JASH", "processNode:----${nodeType}")

        if (node.has("children")) {
            val children = node.getJSONArray("children")
            for (i in 0 until children.length()) {
                val child = children.getJSONObject(i)
                processNode(child, components)
            }
        }

    }


    private fun apiCall(fileId: String, token: String) {
        val loadingDialog = DataLoadingDialog(this@HomeActivity)
        _binding?.apply {
            figmaViewModel.getFigmaFileJson(this@HomeActivity, token, fileId) { apiStatusState ->
                when (apiStatusState) {
                    is ApiStatus.Loading -> {
                        // Show loading state
                        loadingDialog.showLoadingDialog(resources.getString(R.string.loading_progress))
                    }

                    is ApiStatus.Success -> {
                        // Show success state
                        apiStatusState.figmaFileResponse.observe(this@HomeActivity) { fileResponse ->
                            saveFigmaFileResponseToFile(figmaFileResponse = fileResponse) { fileSavedOrError ->
                                if (fileSavedOrError) {
                                    identifyJsonButton.isVisible = true
                                    toastMsg(resources.getString(R.string.file_saved_success))
                                } else {
                                    identifyJsonButton.isVisible = false
                                    toastMsg(resources.getString(R.string.file_saved_fail))
                                }
                            }
                            loadingDialog.dismissDialog()
                            figmaLinkEditText.text = null
                            figmaTokenEditText.text = null
                        }
                    }

                    is ApiStatus.Error -> {
                        // Show error state
                        loadingDialog.dismissDialog()
                        toastMsg(apiStatusState.message)
                        figmaLinkEditText.text = null
                        figmaTokenEditText.text = null
                    }
                }
            }
        }
    }
}