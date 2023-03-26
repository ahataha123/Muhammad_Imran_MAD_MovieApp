package com.example.movieapp.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
            SimpleAppBar(title =movie.title, navController = navController)
            MovieRow(movie = movie, onItemClick = {})
            MovieImageSlider(movieImages = movie.images)
        }
    }
}

@Composable
fun MovieImageSlider(movieImages: List<String>) {
    Column {
        Row(){
            Divider(
                thickness = 2.dp,
                modifier = Modifier.padding(vertical = 5.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Movie Images",
                fontSize = 28.sp,
            )
        }
        LazyRow() {
            items(movieImages) { image ->
                Card(shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    coil.compose.AsyncImage(
                        // make a model using the first images url found in the images array of a movie object
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(image)
                            .crossfade(true)
                            .build(),
                        // a description, define the scale and add some modifiers
                        contentDescription = image,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}



