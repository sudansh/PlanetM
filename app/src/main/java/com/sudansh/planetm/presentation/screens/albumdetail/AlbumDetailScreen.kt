package com.sudansh.planetm.presentation.screens.albumdetail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalUriHandler
import androidx.hilt.navigation.compose.hiltViewModel
import com.sudansh.planetm.presentation.UiState
import com.sudansh.planetm.presentation.screens.view.Loading
import com.sudansh.planetm.presentation.screens.view.RetryContent

@Composable
fun AlbumDetailScreen(
    viewModel: AlbumDetailViewModel = hiltViewModel(),
    albumId: String?,
    onBackClicked: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val localUriHandler = LocalUriHandler.current
    LaunchedEffect(Unit) {
        viewModel.getAlbumDetail(albumId)
    }
    when (state) {
        is UiState.Error -> RetryContent {
            viewModel.getAlbumDetail(albumId = albumId)
        }
        is UiState.Success -> DetailContent(
            album = (state as UiState.Success).data,
            onBackClicked = onBackClicked,
            openLink = { localUriHandler.openUri(it) },
        )
        UiState.Loading -> Loading()
    }
}