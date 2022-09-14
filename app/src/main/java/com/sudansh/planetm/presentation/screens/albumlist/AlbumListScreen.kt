package com.sudansh.planetm.presentation.screens.albumlist

import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.sudansh.planetm.domain.model.Album
import com.sudansh.planetm.presentation.UiState
import com.sudansh.planetm.presentation.screens.view.Loading
import com.sudansh.planetm.presentation.screens.view.RetryContent

@Composable
fun AlbumListScreen(
    viewModel: AlbumListViewModel = hiltViewModel(),
    onAlbumClick: (Album) -> Unit
) {
    val uiState by viewModel.state.collectAsState(UiState.Loading)
    LaunchedEffect(uiState == UiState.Loading) {
        viewModel.refreshData()
    }
    val gridState = rememberLazyGridState()
    Scaffold(
        topBar = {
            val scrollOffset by remember(false) {
                derivedStateOf { gridState.firstVisibleItemScrollOffset == 0 }
            }
            AlbumsAppBar(scrollOffset)
        }) {
        when (uiState) {
            is UiState.Error -> RetryContent(viewModel::refreshData)
            is UiState.Success -> AlbumListContent(
                albums = (uiState as UiState.Success).data, state = gridState, onAlbumClick = onAlbumClick
            )
            UiState.Loading -> Loading()
        }
    }
}