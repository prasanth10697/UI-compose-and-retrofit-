package com.spider.composeapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserDataResponse
import com.spider.composeapp.data.entity.UserDeleteResponse
import com.spider.composeapp.data.entity.UserPostData
import com.spider.composeapp.repository.UserRepository
import com.spider.utilities.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.json.JSONObject
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _getUserData: MutableStateFlow<ResourceState<UserDataResponse>> =
        MutableStateFlow(ResourceState.Loader())
    val getUserData: StateFlow<ResourceState<UserDataResponse>> = _getUserData

    private val _deleteUserData :MutableStateFlow<ResourceState<UserDeleteResponse>> = MutableStateFlow(ResourceState.Loader())
    val deleteUserData :StateFlow<ResourceState<UserDeleteResponse>> = _deleteUserData

    private val _postUserData :MutableStateFlow<ResourceState<Todo>> = MutableStateFlow(ResourceState.Loader())
    val postUserData :StateFlow<ResourceState<Todo>> = _postUserData

    private val _updateUserData :MutableStateFlow<ResourceState<Todo>> = MutableStateFlow(ResourceState.Loader())
    val updateUserData :StateFlow<ResourceState<Todo>> = _updateUserData

    companion object {
        const val TAG = "NewsViewModel"
    }

    init {
        getUserData()
    }

    fun getUserData() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getNewsData()
                .collectLatest {
                    _getUserData.value = it
                    Log.d(TAG, "getNews: ${it.toString()}")
                }
        }
    }

    fun deleteUserData(deleteUserId : Int){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.deleteUserData(deleteUserId)
                .collectLatest {
                    _deleteUserData.value = it
                    Log.d(TAG, "deleteUserData: ${it.toString()}")
                }
        }
    }

    fun postUserData(jsonObject: UserPostData){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.postUserData(jsonObject)
                .collectLatest {
                    _postUserData.value = it
                    Log.d(TAG, "postUserData: ${it.toString()}")
                }
        }
    }

    fun updateUserData(userId: Int, jsonObject: UserPostData){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.updateUserData(userId,jsonObject)
                .collectLatest {
                    _updateUserData.value = it
                    Log.d(TAG, "updateUserData: ${it.toString()}")
                }
        }
    }


}