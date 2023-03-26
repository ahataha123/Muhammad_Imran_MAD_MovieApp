package com.example.movieapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.movieapp.Movie
import com.example.movieapp.getSpecificMovie
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.widgets.SimpleAppBar


@Composable
fun DetailScreen(navController: NavController, movieId: String?) {
    val movie: Movie? = getSpecificMovie(movieId)
    if (movie != null) {
        Column {
            SimpleAppBar(title = movie.title, navController = navController)
            MovieRow(movie = movie, onItemClick = {})
            MovieImages(movie = movie.images)
        }
    }
}

@Composable
fun MovieImages(movie: List<String>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),
            text = "Movie Images",
            fontSize = 35.sp,
        )
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .height(300.dp)
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(movie.size) {
                Card(
                    modifier = Modifier.width(900.dp)
                ) {
                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .crossfade(true)
                            .build()
                    )
                    Image(
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}


