package com.example.galleryapp.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.domain.useCase.GetPhotoUseCase
import com.example.galleryapp.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val getPhotoUseCase: GetPhotoUseCase
) : BaseViewModel() {

    val isLoading = mutableStateOf(false)
    val errorState = mutableStateOf("")
    private val _photos =
        MutableStateFlow<ApiResult<List<PhotoItemEntity>>>(ApiResult.Loading())
    val photos: StateFlow<ApiResult<List<PhotoItemEntity>>> = _photos

    fun loadPhotos() {
        viewModelScope.launch {
            getPhotoUseCase().collect() {result->
                _photos.value = result
            }
        }
    }
}