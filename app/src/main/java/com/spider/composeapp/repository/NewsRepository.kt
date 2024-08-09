package com.spider.composeapp.repository

import com.spider.composeapp.data.datasource.NewsDataSource
import com.spider.composeapp.data.entity.NewsResponse
import com.spider.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NewsRepository @Inject constructor( private val newsDataSource: NewsDataSource) {

    suspend fun getNewsData(country :String):Flow<ResourceState<NewsResponse>>{
        return flow {
            emit(ResourceState.Loader())
            val response =  newsDataSource.getData(country)
            if (response.isSuccessful && response.body()!=null){
                emit(ResourceState.Success(response.body()!!))
            }else{
                emit(ResourceState.Error("Error fetching the news data "))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?:"Some error in flow"))
        }
    }

}