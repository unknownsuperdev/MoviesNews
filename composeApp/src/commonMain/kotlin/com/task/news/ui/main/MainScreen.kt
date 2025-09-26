package com.task.news.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.task.news.component.MovieItem
import com.task.news.component.TopMovieItem
import com.task.screens.Navigation
import com.task.shared.feature.mainpage.MainPageViewModel
import com.task.news.ui.view.ErrorScreen
import com.task.screens.AppScreens
import com.task.shared.feature.mainpage.MainPageState
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun MainRoute(
    navigateDetail: (Navigation) -> Unit,
) {
    val viewModel = koinViewModel<MainPageViewModel>()
    val state = viewModel.viewState
    MainScreen(state, navigateDetail, { viewModel.getUpcomingData() })
}

@Composable
private fun MainScreen(
    state: MainPageState,
    navigate: (Navigation) -> Unit,
    onRetry: () -> Unit
) {
    when {
        state.error != null -> {
            ErrorScreen(onRetry = onRetry)
        }

        state.loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        else -> {
            MainContent(state, navigate)
        }
    }
}

@Composable
private fun MainContent(state: MainPageState, navigate: (Navigation) -> Unit) {
    val movie = state.data?.firstOrNull()
    val movies = state.data?.drop(1)?: emptyList()

    LazyColumn(modifier = Modifier.padding(bottom = 16.dp)) {
        movie?.let { movie ->
            item {
                TopMovieItem(
                    movie
                ) {
                    navigate(AppScreens.MoviesDetail(movie.id))
                }
            }
        }

        items(movies) { item ->
            MovieItem(
                item,
                navigateDetail = {
                    navigate(AppScreens.MoviesDetail(it))
                },
            )
        }
    }
}