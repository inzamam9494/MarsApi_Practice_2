package com.example.marsapi.network

import com.example.marsapi.model.MarsPhoto
import retrofit2.Response
import retrofit2.http.GET

interface MarsApi {
    @GET("photos")
    suspend fun getPhotos() : Response<List<MarsPhoto>>
}
