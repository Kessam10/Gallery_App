package com.example.galleryapp.presentation.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.domain.ApiResult
import com.example.galleryapp.presentation.viewModel.PhotoViewModel


@Composable
fun PhotosScreen(
    modifier: Modifier = Modifier,
    viewModel: PhotoViewModel = hiltViewModel()
) {

    val state by viewModel.photos.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPhotos()
    }

    when (val result = state) {
        is ApiResult.Loading -> Text("Loading...")
        is ApiResult.Error -> Text("Error: ${result.errorMsg}")
        is ApiResult.Success -> {
            LazyColumn(modifier) {
                items(result.data) { photo ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        AsyncImage(
                            model = photo.url,
                            contentDescription = photo.title,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(photo.title ?: "")
                    }
                }
            }
        }
    }
}
