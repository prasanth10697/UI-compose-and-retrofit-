package com.spider.composeapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.spider.composeapp.viewmodel.NewsViewModel
import com.spider.utilities.ResourceState

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    val newsResponse by newsViewModel.news.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        when (newsResponse) {
            is ResourceState.Loader -> {
                Log.d("Home", " ********** loader ********** : ")
            }

            is ResourceState.Success -> {
                val response = (newsResponse as ResourceState.Success).data
                Log.d("Home", " ********** Success ********** :${response.articles[0].title} ")
            }

            is ResourceState.Error -> {
                Log.d("Home", " ********** Error ********** : ")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}