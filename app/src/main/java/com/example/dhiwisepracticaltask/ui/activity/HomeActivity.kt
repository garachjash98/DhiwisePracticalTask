package com.example.dhiwisepracticaltask.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.dhiwisepracticaltask.R
import com.example.dhiwisepracticaltask.databinding.ActivityHomeBinding
import com.example.dhiwisepracticaltask.model.ApiStatus
import com.example.dhiwisepracticaltask.utils.DataLoadingDialog
import com.example.dhiwisepracticaltask.utils.FIGMA_API_RESPONSE_JSON_FILE_NAME
import com.example.dhiwisepracticaltask.utils.IDENTIFY_JSON_FILE_NAME
import com.example.dhiwisepracticaltask.utils.backgroundScope
import com.example.dhiwisepracticaltask.utils.checkJSONFileExitsOrNot
import com.example.dhiwisepracticaltask.utils.extractedFileIdFromFigmaLink
import com.example.dhiwisepracticaltask.utils.loadJSONFromFile
import com.example.dhiwisepracticaltask.utils.mainScope
import com.example.dhiwisepracticaltask.utils.saveFigmaFileResponseToFile
import com.example.dhiwisepracticaltask.utils.saveJsonToFile
import com.example.dhiwisepracticaltask.utils.toastMsg
import com.example.dhiwisepracticaltask.viewmodel.FigmaViewModel
import kotlinx.coroutines.launch

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
                    val jsonFile = loadJSONFromFile(FIGMA_API_RESPONSE_JSON_FILE_NAME)
                    backgroundScope.launch {
                        jsonFile?.let {
                            val document = it.getJSONObject("document")
                            mainScope.launch {
                                saveJsonToFile(
                                    fileName = IDENTIFY_JSON_FILE_NAME,
                                    json = document.toString()
                                ) { fileSavedOrError ->
                                    if (fileSavedOrError) {
                                        toastMsg(resources.getString(R.string.file_saved_success))
                                    } else {
                                        toastMsg(resources.getString(R.string.file_saved_fail))
                                    }
                                }
                            }

                        }

                    }

                } else {
                    toastMsg(resources.getString(R.string.file_not_found))
                }
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
                            saveFigmaFileResponseToFile(
                                fileName = FIGMA_API_RESPONSE_JSON_FILE_NAME,
                                figmaFileResponse = fileResponse
                            ) { fileSavedOrError ->
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