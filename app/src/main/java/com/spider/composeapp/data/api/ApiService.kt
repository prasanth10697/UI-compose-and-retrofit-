package com.spider.composeapp.data.api

import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserDataResponse
import com.spider.composeapp.data.entity.UserDeleteResponse
import com.spider.composeapp.data.entity.UserPostData
import com.spider.composeapp.util.AppConstants
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("todos")
    suspend fun getData(): Response<UserDataResponse>

    @DELETE("todos/{deleteId}")
    suspend fun deleteData(
        @Path("deleteId") deleteId: Int
    ): Response<UserDeleteResponse>

    @POST("todos/add")
    suspend fun postUserData(
        @Body jsonObject: UserPostData
    ):Response<Todo>

    @PUT("todos/{updateUserId}")
    suspend fun updateUserData(
        @Path("updateUserId") userId :Int,
        @Body jsonObject: UserPostData
    ):Response<Todo>
}