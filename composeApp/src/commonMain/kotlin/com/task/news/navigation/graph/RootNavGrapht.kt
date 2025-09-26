package com.task.news.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.task.news.ui.detail.VideoDetailRoute
import com.task.news.ui.main.MainRoute

import com.task.screens.AppScreens
import com.task.screens.Navigation
import com.task.screens.Screens

@Composable
fun RootNavGraph(
    modifier: Modifier = Modifier,
    startDestination: Screens = AppScreens.Home
) {

    val rootNavController: NavHostController = rememberNavController()
    fun navigate(navigation: Navigation) {
        when (navigation) {
            is Navigation.Back -> rootNavController.popBackStack()
            is Navigation.BackTo -> {
                rootNavController.popBackStack(route = navigation.screen, false)
                navigation.payload?.entries?.forEach { entry ->
                    rootNavController.currentBackStackEntry?.savedStateHandle?.set(entry.key, entry.value)
                }
            }
            is AppScreens -> rootNavController.navigate(navigation)
        }
    }

    NavHost(
        navController = rootNavController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        composable<AppScreens.Home> {
            MainRoute(::navigate)
        }

        composable<AppScreens.MoviesDetail> { backStackEntry ->
            val moviesDetail: AppScreens.MoviesDetail = backStackEntry.toRoute()
            VideoDetailRoute(
                moviesDetail.id,
                navigate = ::navigate
            )
        }
    }



}
