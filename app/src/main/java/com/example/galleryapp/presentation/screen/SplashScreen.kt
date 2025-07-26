package com.example.galleryapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.galleryapp.R
import com.example.galleryapp.presentation.viewModel.theme.ThemeViewModel
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(
    onTimeout: () -> Unit
) {
    val themeViewModel: ThemeViewModel = hiltViewModel()
    val isDark by themeViewModel.isDarkMode.collectAsState()

    LaunchedEffect(Unit) {
        delay(2000)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.route_black),
            contentDescription = stringResource(R.string.splash_logo),
            colorFilter = ColorFilter.tint(
                if (isDark) Color.White else Color.Unspecified
            ),
            modifier = Modifier.fillMaxWidth(0.5f)
        )

    }
}
