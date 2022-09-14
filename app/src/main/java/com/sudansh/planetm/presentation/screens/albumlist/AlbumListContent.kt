package com.sudansh.planetm.presentation.screens.albumlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.sudansh.planetm.domain.model.Album

@Composable
fun AlbumListContent(
    albums: List<Album>,
    state: LazyGridState,
    onAlbumClick: (Album) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        state = state
    ) {
        items(
            items = albums,
            key = { it.id }
        ) {
            AlbumCard(it, onAlbumClick)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
private fun LazyGridItemScope.AlbumCard(
    album: Album,
    onAlbumClick: (Album) -> Unit
) {
    Card(
        onClick = { onAlbumClick(album) },
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .aspectRatio(1.0f)
            .animateItemPlacement()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (LocalInspectionMode.current) {
                Box(modifier = Modifier.background(Color.Blue))
            } else {
                SubcomposeAsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(album.thumbnailUrl)
                        .crossfade(true)
                        .build(),
                    loading = {
                        Box(
                            modifier = Modifier.size(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    },
                    contentDescription = album.name,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(listOf(Color.Transparent, Color(0xc0000000)))
                    )
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = album.name,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = album.artistName,
                    style = MaterialTheme.typography.caption,
                    maxLines = 2,
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}