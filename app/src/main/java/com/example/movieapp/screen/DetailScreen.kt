package com.example.movieapp.screen


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieapp.modules.Movie
import com.example.movieapp.modules.getSpecificMovie
import com.example.movieapp.widgets.MovieImageSlider
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

