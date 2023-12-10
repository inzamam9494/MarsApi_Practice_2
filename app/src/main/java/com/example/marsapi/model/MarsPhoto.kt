package com.example.marsapi.model

data class MarsPhoto(
    val id: String?,
    val imgSrc: String?
)

fun MarsPhoto.toMarsPhoto() = MarsPhoto(id, imgSrc)
//continued