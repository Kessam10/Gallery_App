package com.example.galleryapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.galleryapp.presentation.viewModel.network.NetworkViewModel

@Composable
fun NetworkBanner(
    modifier: Modifier = Modifier,
    viewModel: NetworkViewModel = hiltViewModel()
) {
    val isConnected by viewModel.isConnected.collectAsState()

    if (!isConnected) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "You are offline",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
