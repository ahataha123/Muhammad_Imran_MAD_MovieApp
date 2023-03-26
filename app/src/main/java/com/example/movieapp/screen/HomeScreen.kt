package com.example.movieapp.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.Movie
import com.example.movieapp.getMovies
import com.example.movieapp.widgets.MovieRow
import com.example.movieapp.widgets.TopAppBar
import okhttp3.Route

@Composable
fun HomeScreen(navController: NavController) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            TopAppBar(navController)
            MovieList(navController)
        }

    }
}

@Composable
fun MovieList(navController: NavController = rememberNavController(),
              movies: List<Movie> = getMovies()
) {
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie = movie) { movieId ->
                navController.navigate(Screen.DetailScreen.route + "/$movieId")
            }
        }
    }
}






