package com.example.galleryapp.composable

import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.example.galleryapp.presentation.viewModel.theme.ThemeViewModel

@Composable
fun ThemeToggle(
    viewModel: ThemeViewModel,
    isDark: Boolean,
    modifier: Modifier = Modifier
) {

//        Text(text = if (isDark) "Dark Mode" else "Light Mode")
        Switch(
            checked = isDark,
            onCheckedChange = {
                viewModel.toggleTheme(isDark)
            }
        )
    }

