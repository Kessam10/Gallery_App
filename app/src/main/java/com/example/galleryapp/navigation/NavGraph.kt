package com.example.galleryapp.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.galleryapp.composable.NetworkBanner
import com.example.galleryapp.presentation.screen.PhotosScreen
import com.example.galleryapp.presentation.screen.SplashScreen

object Routes {
    const val SPLASH = "splash"
    const val PHOTOS = "photos"
}

@Composable
fun NavGraph(modifier: Modifier=Modifier,navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SPLASH, modifier = modifier) {
        composable(Routes.SPLASH) {
            SplashScreen {
                navController.navigate(Routes.PHOTOS) {
                    popUpTo(Routes.SPLASH) { inclusive = true }
                }
            }
        }
        composable(Routes.PHOTOS) {
            Column {
                NetworkBanner()
                PhotosScreen()
            }
        }
    }
}
