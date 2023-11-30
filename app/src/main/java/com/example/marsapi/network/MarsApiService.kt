package com.example.marsapi.network

import com.example.marsapi.model.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MarsApiService @Inject constructor(private val marsApi: MarsApi) {
    suspend fun getPhotos(): List<MarsPhoto>{
        return withContext(Dispatchers.IO){
            val photos = marsApi.getPhotos()
            photos.body() ?: emptyList()
        }
    }
}