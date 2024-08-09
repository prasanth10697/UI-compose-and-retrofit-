package com.spider.composeapp.data.datasource

import com.spider.composeapp.data.entity.NewsResponse
import retrofit2.Response

interface NewsDataSource {
    suspend fun getData(country :String ): Response<NewsResponse>
}