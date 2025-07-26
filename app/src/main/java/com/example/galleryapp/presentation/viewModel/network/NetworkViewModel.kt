package com.example.galleryapp.presentation.viewModel.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.base.BaseViewModel
import com.example.galleryapp.utils.network.NetworkObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val networkObserver: NetworkObserver
) : BaseViewModel() {
    val isConnected = networkObserver.isConnected
}
