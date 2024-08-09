package com.spider.composeapp.data.datasource

import com.spider.composeapp.data.api.ApiService
import com.spider.composeapp.data.entity.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsDataSourceImpl @Inject constructor(
   private val apiService: ApiService
):NewsDataSource {

    override suspend fun getData(country: String): Response<NewsResponse> {
        return apiService.getData(country)
    }
}