package com.example.thecomposedhr

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.thecomposedhr.data.DataSource
import com.example.thecomposedhr.data.models.Artwork

@Composable
fun MyArtSpaceApp(navController: NavHostController) {
    Scaffold(
        topBar = {
            CustomToolbarWithBackArrow(title = stringResource(id = R.string.txt_my_art_space), navController)
        },
        content = {

            val artworkList = DataSource.artworkList

            var artworkCount by remember {
                mutableStateOf(0)
            }

            Surface(color = Color.White) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    ArtWorkWall(artworkList[artworkCount].artworkImage)
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtWorkDescriptor(artworkList[artworkCount])
                    Spacer(modifier = Modifier.height(10.dp))
                    ArtWorkDisplayController(artworkCount, onPreviousClick = {
                        if (artworkCount >= 1) {
                            artworkCount -= 1
                        }
                    }) {
                        if (artworkCount <= 3) {
                            artworkCount += 1
                        }
                    }
                }
            }
        }
    )
}

@Composable
fun ArtWorkWall(artworkImage: Int) {
    Surface(
        color = Color.White,
        border = BorderStroke(2.dp, color = Color.DarkGray),
        elevation = 5.dp, modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(20.dp)
    ) {
        Image(
            modifier = Modifier
                .padding(30.dp)
                .wrapContentWidth()
                .height(300.dp),
            contentScale = ContentScale.FillHeight,
            painter = painterResource(id = artworkImage),
            contentDescription = null
        )
    }
}

@Composable
fun ArtWorkDescriptor(artwork: Artwork) {
    Card(
        elevation = 3.dp, modifier = Modifier
            .wrapContentWidth()
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentWidth()
                .padding(10.dp)
        ) {
            Text(
                artwork.artworkTitle,
                fontSize = 20.sp, fontWeight = FontWeight.W300
            )
            Row() {
                Text(artwork.artistName, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(5.dp))
                Text("(${artwork.artworkYear})", fontWeight = FontWeight.Light)
            }
        }
    }
}

@Composable
fun ArtWorkDisplayController(
    artworkCount: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.wrapContentWidth(),
            enabled = artworkCount >= 0,
        ) {
            Text(text = stringResource(R.string.txt_previous))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onNextClick,
            modifier = Modifier.wrapContentWidth(),
            enabled = artworkCount <= 4,
        ) {
            Text(text = stringResource(R.string.txt_next))
        }
    }
}