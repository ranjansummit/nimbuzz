package com.nimbuzz.photoapp.ui.component

import android.app.Activity
import android.net.Uri
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nimbuzz.photoapp.ui.screens.mainscreen.MainViewModel
import com.nimbuzz.photoapp.ui.theme.DefaultBackgroundColor
import com.nimbuzz.photoapp.ui.theme.Purple200
import com.nimbuzz.photoapp.ui.theme.Purple500
import com.nimbuzz.photoapp.ui.theme.SecondaryFontColor
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.animation.circular.CircularRevealPlugin
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.placeholder.shimmer.Shimmer
import com.skydoves.landscapist.placeholder.shimmer.ShimmerPlugin

@Composable
fun PhotosItemList(
    photos: Pair<Uri?, Uri?>,
    size:Int = 0,

    ) {
    val mainViewModel = hiltViewModel<MainViewModel>()
    val activity = (LocalContext.current as? Activity)
    val progressBar = remember { mutableStateOf(false) }
    if (size>0)
      mainViewModel.updateTriangularList(size)
    Column(modifier = Modifier.background(DefaultBackgroundColor)) {

        CircularIndeterminateProgressBar(isDisplayed = progressBar.value, 0.4f)
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                ,
            content = {
                if (mainViewModel.imageList.value.first!=null && mainViewModel.imageList.value.second!=null)
                {
                items(count = size ) { index ->

                        PhotoItemView( if (mainViewModel.triangularList.value.contains(index + 1)) photos.first!! else photos.second!!)

                }
            }


            })
    }

}


@Composable
fun PhotoItemView(uri: Uri) {
    Column(modifier = Modifier.padding(start = 5.dp, end = 5.dp, top = 0.dp, bottom = 10.dp)) {
        CoilImage(
            modifier = Modifier
                .size(250.dp)
                .clickable {
//                    navController.navigate(Screen.MovieDetail.route.plus("/${item.id}"))
                },
            imageModel = { uri },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = "Movie item",
                colorFilter = null,
            ),
            component = rememberImageComponent {
                +CircularRevealPlugin(
                    duration = 800
                )
                +ShimmerPlugin(shimmer = Shimmer.Flash(
                    baseColor = SecondaryFontColor,
                    highlightColor = DefaultBackgroundColor
                ))
            },
        )
    }
}

@Composable
fun SelectableGenreChip(
    selected: Boolean,
    genre: String,
    onclick: () -> Unit
) {

    val animateChipBackgroundColor by animateColorAsState(
        targetValue = if (selected) Purple500 else Purple200,
        animationSpec = tween(
            durationMillis = 50,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .background(
                color = animateChipBackgroundColor
            )
            .height(32.dp)
            .widthIn(min = 80.dp)
            .padding(horizontal = 8.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onclick()
            }
    ) {
        Text(
            text = genre,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White.copy(alpha = 0.80F)
        )
    }
}



