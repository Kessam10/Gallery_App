package com.example.galleryapp.composable

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.galleryapp.presentation.viewModel.theme.ThemeViewModel

@Composable
fun ThemeToggle(viewModel: ThemeViewModel, isDark: Boolean) {
    Switch(
        checked = isDark,
        onCheckedChange = {
            viewModel.toggleTheme(isDark)
        }
    )
}

