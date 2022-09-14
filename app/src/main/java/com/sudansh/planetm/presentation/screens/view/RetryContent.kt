package com.sudansh.planetm.presentation.screens.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sudansh.planetm.R
import com.sudansh.planetm.theme.PlanetMTheme

@Composable
fun RetryContent(
    onRetry: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                stringResource(id = R.string.something_went_wrong),
                color = MaterialTheme.colors.secondary
            )
            Button(
                onClick = onRetry
            ) {
                Text(
                    text = stringResource(R.string.retry),
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewErrorComponent() {
    PlanetMTheme {
        Surface {
            RetryContent {}
        }
    }
}