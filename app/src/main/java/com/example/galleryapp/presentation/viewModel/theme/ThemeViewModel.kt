package com.example.galleryapp.presentation.viewModel.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.galleryapp.utils.preferences.ThemePreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themeManager: ThemePreferenceManager
) : ViewModel() {

    val isDarkMode = themeManager.isDarkMode
        .stateIn(viewModelScope, SharingStarted.Eagerly, false)

    fun toggleTheme(current: Boolean) {
        viewModelScope.launch {
            themeManager.setDarkMode(!current)
        }
    }
}

