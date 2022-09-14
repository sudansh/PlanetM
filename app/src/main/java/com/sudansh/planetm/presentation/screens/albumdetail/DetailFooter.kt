package com.sudansh.planetm.presentation.screens.albumdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sudansh.planetm.R

@Composable
fun DetailFooter(
    albumInfo: String,
    openLink: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 47.dp)
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = albumInfo,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = openLink,
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.heightIn(min = 45.dp),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                text = stringResource(id = R.string.url_button_title),
                style = MaterialTheme.typography.body1,
            )
        }
    }
}