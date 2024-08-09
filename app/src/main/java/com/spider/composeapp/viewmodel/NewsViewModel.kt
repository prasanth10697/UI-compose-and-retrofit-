package com.spider.composeapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spider.composeapp.data.entity.NewsResponse
import com.spider.composeapp.repository.NewsRepository
import com.spider.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) :ViewModel(){

    val _news : MutableStateFlow<ResourceState<NewsResponse>> = MutableStateFlow(ResourceState.Loader())
    val news :StateFlow<ResourceState<NewsResponse>> = _news

    companion object{
        const val TAG ="NewsViewModel"
    }

    init {
        getNews("us")
    }

    private fun getNews(country :String){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.getNewsData(country)
                .collectLatest {
                    _news.value = it
                    Log.d(TAG, "getNews: ${it.toString()}")
                }
        }
    }


}