package com.make.deve.pruebacoink.remote.info

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InfoContract {
    @GET("/qa/signup/documentTypes")
    suspend fun getDocTypes(
        @Query("apiKey") apiKey : String
    ): Response<String>

    @GET("/qa/signup/genders")
    suspend fun getGender(
        @Query("apiKey") apiKey : String
    ): Response<String>
}