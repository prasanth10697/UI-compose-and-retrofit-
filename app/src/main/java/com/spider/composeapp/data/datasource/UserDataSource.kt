package com.spider.composeapp.data.datasource

import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserDataResponse
import com.spider.composeapp.data.entity.UserDeleteResponse
import com.spider.composeapp.data.entity.UserPostData
import org.json.JSONObject
import retrofit2.Response

interface UserDataSource {
    suspend fun getData(): Response<UserDataResponse>
    suspend fun deleteUserData(deleteId:Int): Response<UserDeleteResponse>
    suspend fun postUserData(jsonObject: UserPostData): Response<Todo>
    suspend fun updateUserData(userId: Int, jsonObject: UserPostData): Response<Todo>
}