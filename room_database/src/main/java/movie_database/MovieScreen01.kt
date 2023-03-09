package movie_database

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import movie_database.model.Movie
import movie_database.ui.theme.ServiceAndSecurityTheme

class MovieScreen01 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ServiceAndSecurityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(name: String) {
    var movie by mutableStateOf<Movie?>(Movie("ABCD","abc"))

    Column() {
        movie?.let {it->
            MovieDisplay(movie = it)
        }
        BoxedText(name = "Abul")
        BoxedText(name = "Babul")
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ServiceAndSecurityTheme {
        Greeting("Android")
    }
}