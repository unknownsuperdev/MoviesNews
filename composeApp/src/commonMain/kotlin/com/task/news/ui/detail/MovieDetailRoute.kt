package com.task.news.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.task.news.component.SimpleTopBar
import com.task.screens.Navigation
import com.task.shared.feature.detail.MovieDetailState
import com.task.shared.feature.detail.MovieDetailViewModel
import moviesnews.composeapp.generated.resources.Res
import moviesnews.composeapp.generated.resources.detail
import org.jetbrains.compose.resources.stringResource

@Composable
fun VideoDetailRoute(
    detailId: Int,
    navigate: (Navigation) -> Unit,
) {
    val viewModel: MovieDetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel {
        MovieDetailViewModel(detailId)
    }
    val state = viewModel.viewState
    VideoDetailScreen(
        movieDetailsState = state,
        onBackClick = { navigate(Navigation.Back) }
    )
}

@Composable
internal fun VideoDetailScreen(
    movieDetailsState: MovieDetailState,
    onBackClick: () -> Unit
) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                title = stringResource(Res.string.detail),
                onBackClick = onBackClick
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = movieDetailsState.detailItem?.posterUrl,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = movieDetailsState.detailItem?.title.orEmpty(),
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurface,
            )
            if (movieDetailsState.detailItem?.voteAverage != null) {
                MovieRatingSection(
                    popularity = movieDetailsState.detailItem?.getPopularity(),
                    voteAverage = movieDetailsState.detailItem?.getRating()
                )
            }

            if (!movieDetailsState.detailItem?.overview.isNullOrEmpty()) {
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Overview",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    text = movieDetailsState.detailItem?.overview ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 15.sp,
                )
            }

        }
    }
}
