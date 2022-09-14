package com.sudansh.planetm.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sudansh.planetm.presentation.screens.albumdetail.AlbumDetailScreen
import com.sudansh.planetm.presentation.screens.albumlist.AlbumListScreen

@Composable
fun AlbumApp(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "albumList",
        modifier = Modifier
            .fillMaxSize()
    ) {
        composable("albumList") {
            AlbumListScreen {
                navController.navigate(route = "albumDetail/${it.id}")
            }
        }
        composable(
            "albumDetail/{albumId}",
        ) {
            AlbumDetailScreen(
                albumId = it.arguments?.getString("albumId")
            ) {
                navController.popBackStack()
            }
        }
    }
}