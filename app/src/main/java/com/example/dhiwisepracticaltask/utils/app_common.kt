package com.example.dhiwisepracticaltask.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import com.example.dhiwisepracticaltask.model.FigmaFileResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter


const val FOLDER_NAME = "Figma Auto Identification"
const val JSON_RESPONSE_FILE_NAME = "figma_file_response.json"


/*Coroutines Scopes*/
val backgroundScope = CoroutineScope(Dispatchers.IO)
val mainScope = CoroutineScope(Dispatchers.Main)

//Common method to launch new screen
fun <T> Context.launchActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

fun Context.toastMsg(toastText: CharSequence) =
    Toast.makeText(this, toastText, Toast.LENGTH_LONG).show()

fun Context.isInternetAvailable(): Boolean {
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
}

//Fetch Figma File Id
fun extractedFileIdFromFigmaLink(figmaUrl: String): String? {
    val regex = "file/([a-zA-Z0-9]+)".toRegex()
    val matchResult = regex.find(figmaUrl)
    return matchResult?.groups?.get(1)?.value
}

// Save FigmaFileResponse LiveData to JSON file
fun saveFigmaFileResponseToFile(
    figmaFileResponse: FigmaFileResponse,
    onFileSaved: (Boolean) -> Unit
) {
    val gson = Gson()
    val json = gson.toJson(figmaFileResponse)
    saveJsonToFile(json = json, onFileSaved = onFileSaved)
}

private fun saveJsonToFile(json: String, onFileSaved: (Boolean) -> Unit) {
    val folderName = "Figma Auto Identification"
    val downloadFolder =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val folder = File(downloadFolder, folderName)
    // Create the folder if it doesn't exist
    if (!folder.exists()) {
        folder.mkdirs()
    }
    val file = File(folder, "figma_file_response.json")
    try {
        if (file.exists()) {
            file.delete()
            FileOutputStream(file).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(json)
                    onFileSaved(true)
                }
            }
        } else {
            FileOutputStream(file).use { outputStream ->
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(json)
                    onFileSaved(true)
                }
            }
        }

    } catch (e: Exception) {
        onFileSaved(false)
        e.printStackTrace()
    }
}

fun checkJSONFileExitsOrNot():Boolean{
    val downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val folder = File(downloadFolder, FOLDER_NAME)
    val file = File(folder, JSON_RESPONSE_FILE_NAME)
    return file.exists()
}


fun loadJSONFromFile(fileName: String): JSONObject? {
    val downloadFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS + "/" + FOLDER_NAME)
    val file = File(downloadFolder, fileName)
    return if (file.exists()) {
        val inputStream = FileInputStream(file)
        val jsonStr = InputStreamReader(inputStream).readText()
        JSONObject(jsonStr)
    } else {
        null
    }
}