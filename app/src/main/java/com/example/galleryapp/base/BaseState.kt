package com.example.galleryapp.base

import androidx.compose.runtime.Immutable

@Immutable
data class BaseState(
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)