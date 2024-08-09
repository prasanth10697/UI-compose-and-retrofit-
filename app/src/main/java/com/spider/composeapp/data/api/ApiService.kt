package com.spider.composeapp.data.api

import com.spider.composeapp.data.entity.NewsResponse
import com.spider.composeapp.util.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2/top-headlines")
   suspend fun getData(
        @Query("country") country :String,
        @Query("apiKey") apiKey :String = AppConstants.API_KEY
    ): Response<NewsResponse>

}