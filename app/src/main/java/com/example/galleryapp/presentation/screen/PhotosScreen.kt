package com.example.galleryapp.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.domain.ApiResult
import com.example.domain.entities.PhotoItemEntity
import com.example.galleryapp.presentation.viewModel.photos.PhotoViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import com.example.galleryapp.presentation.viewModel.theme.ThemeViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.stringResource
import com.example.galleryapp.R
import com.example.galleryapp.composable.ThemeToggle

@Composable
fun PhotosScreen(
    modifier: Modifier = Modifier,
    viewModel: PhotoViewModel = hiltViewModel(),
    themeViewModel: ThemeViewModel = hiltViewModel()
) {
    val state by viewModel.photos.collectAsState()
    val isDark by themeViewModel.isDarkMode.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadPhotos()
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(stringResource(R.string.route), style = MaterialTheme.typography.headlineMedium)
            ThemeToggle(themeViewModel, isDark)
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (val result = state) {
            is ApiResult.Loading -> {
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Loading...", style = MaterialTheme.typography.bodyLarge)
                }
            }

            is ApiResult.Error -> {
                Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Error: ${result.errorMsg}", style = MaterialTheme.typography.bodyLarge)
                }
            }

            is ApiResult.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(result.data.filterNotNull()) { photo ->
                        PhotoGridItem(photo)
                    }
                }
            }
        }
    }
}

@Composable
fun PhotoGridItem(photo: PhotoItemEntity) {
    Image(
        painter = rememberAsyncImagePainter(photo.url ?: photo.thumbnailUrl),
        contentDescription = photo.title,
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(12.dp))
    )
}


//
//@Composable
//fun PhotosScreen(
//    modifier: Modifier = Modifier,
//    viewModel: PhotoViewModel = hiltViewModel()
//) {
//    val state by viewModel.photos.collectAsState()
//
//    LaunchedEffect(Unit) {
//        viewModel.loadPhotos()
//    }
//
//    when (val result = state) {
//        is ApiResult.Loading -> {
//            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Text("Loading...", style = MaterialTheme.typography.bodyLarge)
//            }
//        }
//
//        is ApiResult.Error -> {
//            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Text("Error: ${result.errorMsg}", style = MaterialTheme.typography.bodyLarge)
//            }
//        }
//
//        is ApiResult.Success -> {
//            LazyColumn(
//                modifier = modifier
//                    .fillMaxSize()
//                    .padding(8.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                items(result.data) { photo ->
//                    PhotoItem(photo)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun PhotoItem(photo: PhotoItemEntity?) {
//    if (photo == null) return
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Image(
//            painter = rememberAsyncImagePainter(photo.thumbnailUrl ?: photo.url),
//            contentDescription = photo.title,
//            modifier = Modifier
//                .size(64.dp)
//                .padding(end = 8.dp),
//            contentScale = ContentScale.Crop
//        )
//
//        Text(
//            text = photo.title ?: "No Title",
//            style = MaterialTheme.typography.bodyMedium,
//            maxLines = 2,
//            overflow = TextOverflow.Ellipsis,
//            modifier = Modifier.weight(1f)
//        )
//    }
//}
