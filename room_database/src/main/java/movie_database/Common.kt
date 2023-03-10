package movie_database

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import movie_database.model.Movie

@Composable
fun BoxedText(name: String, onClick: () -> Unit = {}) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)//used as margin
            .border(width = 2.dp, color = MaterialTheme. colorScheme.primary)
            .padding(8.dp)
            .clickable { onClick() },
        text = name
    )

}

@Composable
fun Label(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        text = text,
        style = MaterialTheme.typography.labelMedium
    )

}

@Composable
fun Display(text: String, modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 8.dp),
        text = text,
        style = MaterialTheme.typography.titleSmall
    )

}

@Composable
fun MovieDisplay(movie: Movie) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Label(text = "Title")
        Display(text = movie.title)
        Label(text = "Description")
        Display(text = movie.description)

    }
}