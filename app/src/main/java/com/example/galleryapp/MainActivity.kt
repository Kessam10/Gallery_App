package com.example.galleryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.galleryapp.composable.NetworkBanner
import com.example.galleryapp.composable.ThemeToggle
import com.example.galleryapp.presentation.screen.PhotosScreen
import com.example.galleryapp.presentation.viewModel.theme.ThemeViewModel
import com.example.galleryapp.ui.theme.GalleryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: ThemeViewModel = hiltViewModel()
            val isDarkMode by viewModel.isDarkMode.collectAsState()

            GalleryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        NetworkBanner()
                        ThemeToggle(viewModel, isDarkMode)
                        PhotosScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }

        }
    }
}
