package com.example.marsapi.repository

import com.example.marsapi.model.MarsPhoto
import com.example.marsapi.model.toMarsPhoto
import com.example.marsapi.network.MarsApiService
import javax.inject.Inject

class MarsRepository @Inject constructor(private val marsApiService: MarsApiService){
    suspend fun getPhotos(): List<MarsPhoto>{
        return marsApiService.getPhotos().map {
            it.toMarsPhoto()
        }
    }
}

class GetPhotoUseCase @Inject constructor(private val marsRepository: MarsRepository){
    suspend operator fun invoke() : List<MarsPhoto>{
        return marsRepository.getPhotos().shuffled()
    }
}