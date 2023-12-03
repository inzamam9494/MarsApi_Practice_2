package com.example.marsapi.ui.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsapi.model.MarsPhoto
import com.example.marsapi.repository.GetPhotoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

private const val failed = "Failed to Load"

@HiltViewModel
class MarsViewModel @Inject constructor( private val getPhotoUseCase: GetPhotoUseCase): ViewModel(){
    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos : LiveData<List<MarsPhoto>> get() = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos(){
        viewModelScope.launch {
            try {
                val photos = getPhotoUseCase()
                _photos.value = photos
                Log.d(TAG,"Success ${photos.size} Mars Photo retrieved")
            }
            catch (e:IOException){
                failed
                Log.d(TAG, failed)
            }
        }
    }

    companion object{
        val TAG = "MarsApi"
    }

}