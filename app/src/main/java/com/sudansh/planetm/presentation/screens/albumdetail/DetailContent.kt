package com.sudansh.planetm.presentation.screens.albumdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sudansh.planetm.R
import com.sudansh.planetm.domain.model.Album
import com.sudansh.planetm.theme.PlanetMTheme
import com.sudansh.planetm.utils.DateUtil

@Composable
fun DetailContent(
    album: Album,
    onBackClicked: () -> Unit,
    openLink: (String) -> Unit
) {
    val releaseDate by derivedStateOf {
        DateUtil.format(album.releaseData)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        DetailHeader(
            imageUrl = album.artworkUrl,
            name = album.name,
            onBack = onBackClicked
        )
        DetailInfo(
            artist = album.artistName,
            album = album.name,
            genres = album.genres
        )
        Spacer(modifier = Modifier.weight(1f))
        DetailFooter(
            albumInfo = stringResource(
                id = R.string.relase_info,
                releaseDate,
                album.copyright
            ),
            openLink = { openLink(album.url) }
        )
    }
}

@Preview
@Composable
fun PreviewDetailContent() {
    PlanetMTheme {
        Surface {
            DetailContent(
                album = Album(
                    id = "1",
                    name = "name",
                    artworkUrl = "",
                    artistName = "artist",
                    genres = listOf(),
                    releaseData = "2023",
                    copyright = "Copyright",
                    url = "",
                    thumbnailUrl = "",
                ),
                onBackClicked = { },
                openLink = { },
            )
        }
    }
}