package com.example.movieapp.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.movieapp.ui.theme.MovieAppTheme

// Done with Adam Ibragimov,Kenan Husic
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Navigation()
                }

            }
        }
    }







