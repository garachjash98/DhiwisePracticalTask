package com.example.dhiwisepracticaltask.retrofit

import com.example.dhiwisepracticaltask.model.FigmaFileResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FigmaApiInterface {
    @GET("v1/files/{file_id}")
    fun getFile(
        @Header("X-FIGMA-TOKEN") token: String,
        @Path("file_id") fileId: String
    ): Call<FigmaFileResponse>
}