package com.spider.composeapp.data.datasource

import com.spider.composeapp.data.api.ApiService
import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserDataResponse
import com.spider.composeapp.data.entity.UserDeleteResponse
import com.spider.composeapp.data.entity.UserPostData
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class UserDataSourceImpl @Inject constructor(
   private val apiService: ApiService
):UserDataSource {

    override suspend fun getData(): Response<UserDataResponse> {
        return apiService.getData()
    }

    override suspend fun deleteUserData(deleteId: Int): Response<UserDeleteResponse> {
        return apiService.deleteData(deleteId)
    }

    override suspend fun postUserData(jsonObject: UserPostData): Response<Todo> {
        return apiService.postUserData(jsonObject)
    }

    override suspend fun updateUserData(userId: Int, jsonObject: UserPostData): Response<Todo> {
        return apiService.updateUserData(userId,jsonObject)
    }

}