package com.example.galleryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.galleryapp.presentation.screen.PhotosScreen
import com.example.galleryapp.presentation.screen.SplashScreen

object Routes {
    const val SPLASH = "splash"
    const val PHOTOS = "photos"
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SPLASH) {
        composable(Routes.SPLASH) {
            SplashScreen {
                navController.navigate(Routes.PHOTOS) {
                    popUpTo(Routes.SPLASH) { inclusive = true } // remove splash from backstack
                }
            }
        }
        composable(Routes.PHOTOS) {
            PhotosScreen()
        }
    }
}
