package com.example.dhiwisepracticaltask.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dhiwisepracticaltask.model.FigmaFileResponse
import com.example.dhiwisepracticaltask.retrofit.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FigmaRepository {

    private val figmaApi = RetrofitBuilder.figmaApi

    suspend fun getFile(token: String, fileId: String): FigmaFileResponse {
        return withContext(Dispatchers.IO) {
            val response = figmaApi.getFile(token, fileId).execute()
            if (response.isSuccessful) {
                response.body() ?: throw Exception("Response body is null")
            } else {
                throw Exception("Error fetching file: ${response.message()}")
            }
        }
    }
}