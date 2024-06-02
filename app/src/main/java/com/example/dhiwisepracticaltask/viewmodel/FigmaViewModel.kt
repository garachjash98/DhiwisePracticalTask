package com.example.dhiwisepracticaltask.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dhiwisepracticaltask.R
import com.example.dhiwisepracticaltask.model.ApiStatus
import com.example.dhiwisepracticaltask.model.FigmaFileResponse
import com.example.dhiwisepracticaltask.repository.FigmaRepository
import com.example.dhiwisepracticaltask.utils.backgroundScope
import com.example.dhiwisepracticaltask.utils.isInternetAvailable
import com.example.dhiwisepracticaltask.utils.mainScope
import kotlinx.coroutines.launch

class FigmaViewModel : ViewModel() {
    private val repository = FigmaRepository()
    private val _figmaFileResponse = MutableLiveData<FigmaFileResponse>()
    private val figmaFileResponse: LiveData<FigmaFileResponse> get() = _figmaFileResponse

    fun getFigmaFileJson(context: Context,token: String, fileId: String, onStateChanged: (ApiStatus) -> Unit) {
        onStateChanged(ApiStatus.Loading)
        if(context.isInternetAvailable()){
            backgroundScope.launch {
                try {
                    val response = repository.getFile(token, fileId)
                    _figmaFileResponse.postValue(response)
                    mainScope.launch {
                        onStateChanged(ApiStatus.Success(figmaFileResponse))
                    }
                } catch (e: Exception) {
                    // Handle the exception, maybe post a value to indicate an error
                    mainScope.launch {
                        val errorMessage = "Error fetching file: ${e.message}"
                        onStateChanged(ApiStatus.Error(errorMessage))
                    }
                }
            }
        }
        else{
            val internetError = context.resources.getString(R.string.internet_error)
            onStateChanged(ApiStatus.Error(internetError))
        }
    }
}