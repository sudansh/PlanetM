package com.sudansh.planetm.presentation.screens.albumlist

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sudansh.planetm.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AlbumsAppBar(isZeroScroll: Boolean) {
    val fontSize = animateIntAsState(if (isZeroScroll) 34 else 16, animationSpec = TweenSpec(150, 0))
    val heightState = animateDpAsState(if (isZeroScroll) 65.dp else 43.dp, animationSpec = TweenSpec(150, 0))
    AnimatedContent(targetState = isZeroScroll,
        transitionSpec = {
            if (targetState) {
                slideInHorizontally { it / 4 } + fadeIn() with slideOutHorizontally { -it / 4 } + fadeOut()
            } else {
                slideInHorizontally { -it / 4 } + fadeIn() with slideOutHorizontally { it / 4 } + fadeOut()
            }
        }) {
        TopAppBar(
            modifier = Modifier
                .statusBarsPadding()
                .height(heightState.value),
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.detail_title),
                    style = MaterialTheme.typography.h1,
                    fontSize = fontSize.value.sp,
                    textAlign = if (isZeroScroll) TextAlign.Left else TextAlign.Center
                )
            },
            backgroundColor = Color.White.copy(alpha = 0.5f),
            elevation = 0.dp,
        )
    }
}