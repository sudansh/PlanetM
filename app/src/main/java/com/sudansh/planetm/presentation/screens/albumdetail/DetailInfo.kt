package com.sudansh.planetm.presentation.screens.albumdetail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun DetailInfo(
    artist: String,
    album: String,
    genres: List<String>
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = artist,
            style = MaterialTheme.typography.body2,
            maxLines = 2
        )
        Text(
            text = album,
            style = MaterialTheme.typography.h1,
            maxLines = 2
        )
        Spacer(modifier = Modifier.height(8.dp))
        DetailGenres(genres = genres)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
private fun DetailGenres(genres: List<String>) {
    FlowRow(
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp,
    ) {
        genres.forEach { genre ->
            Text(
                modifier = Modifier
                    .border(
                        BorderStroke(1.dp, MaterialTheme.colors.primary),
                        shape = RoundedCornerShape(1000.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                text = genre,
                style = MaterialTheme.typography.caption.copy(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.None
                    )
                ),
                color = MaterialTheme.colors.primary
            )
        }
    }
}