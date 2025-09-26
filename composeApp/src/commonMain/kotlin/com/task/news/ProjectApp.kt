package com.task.news

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.task.news.navigation.graph.RootNavGraph
import com.task.shared.di.externalSharedModule
import org.koin.compose.KoinApplication

@Composable
fun ProjectApp() {
    KoinApplication(application = {
        modules(externalSharedModule)
    }) {
        MaterialTheme {
            RootNavGraph()
        }
    }
}
