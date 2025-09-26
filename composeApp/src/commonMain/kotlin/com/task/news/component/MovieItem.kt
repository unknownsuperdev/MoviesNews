package com.task.news.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.task.models.UiMovie

@Composable
fun MovieItem(
    movie: UiMovie,
    navigateDetail: (Int) -> Unit = {},
) {

    Box(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                navigateDetail(movie.id)
            }
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        Row(
            Modifier
                .padding(all = 4.dp)
                .fillMaxSize()
        ) {

            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .height(200.dp)
                    .width(120.dp)
                    .clip(RoundedCornerShape(8.dp)),
                painter = rememberAsyncImagePainter(
                    movie.posterUrl
                ),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            Column(
                verticalArrangement = Top,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 12.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.labelMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card {

                }
                RatingBar(
                    rating = movie.rating,
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    text = movie.overview,
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle.Default.copy(
                        color = Color.LightGray
                    ),
                    letterSpacing = 0.6.sp
                )
            }
        }
    }
}