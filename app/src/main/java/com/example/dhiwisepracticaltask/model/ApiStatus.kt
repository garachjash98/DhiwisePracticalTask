package com.example.dhiwisepracticaltask.model

import androidx.lifecycle.LiveData

sealed class ApiStatus {
    data object Loading : ApiStatus()
    data class Success(val figmaFileResponse: LiveData<FigmaFileResponse>) : ApiStatus()
    data class Error(val message: String) : ApiStatus()
}