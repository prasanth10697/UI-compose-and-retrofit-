package com.spider.composeapp.repository

import com.spider.composeapp.data.datasource.UserDataSource
import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserDataResponse
import com.spider.composeapp.data.entity.UserDeleteResponse
import com.spider.composeapp.data.entity.UserPostData
import com.spider.utilities.ResourceState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDataSource: UserDataSource) {

    suspend fun getNewsData(): Flow<ResourceState<UserDataResponse>> {
        return flow {
            emit(ResourceState.Loader())
            val response = userDataSource.getData()
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error fetching the news data "))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?: "Some error in flow"))
        }
    }

    suspend fun deleteUserData(deleteId: Int): Flow<ResourceState<UserDeleteResponse>> {
        return flow {
            emit(ResourceState.Loader())
            val response = userDataSource.deleteUserData(deleteId)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error not delete user"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?: "some error in flow"))
        }
    }

    suspend fun postUserData(jsonObject: UserPostData): Flow<ResourceState<Todo>> {
        return flow {
            emit(ResourceState.Loader())
            val response = userDataSource.postUserData(jsonObject)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error not post user"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?: "some error in flow"))
        }
    }

    suspend fun updateUserData(userId: Int, jsonObject: UserPostData): Flow<ResourceState<Todo>> {
        return flow {
            emit(ResourceState.Loader())
            val response = userDataSource.updateUserData(userId, jsonObject)
            if (response.isSuccessful && response.body() != null) {
                emit(ResourceState.Success(response.body()!!))
            } else {
                emit(ResourceState.Error("Error not post user"))
            }
        }.catch {
            emit(ResourceState.Error(it.localizedMessage ?: "some error in flow"))
        }
    }

}