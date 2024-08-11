package com.spider.composeapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spider.composeapp.data.entity.Todo
import com.spider.composeapp.data.entity.UserPostData
import com.spider.composeapp.viewmodel.UserViewModel
import com.spider.utilities.ResourceState
import org.json.JSONObject

@Composable
fun HomeScreen(
    userViewModel: UserViewModel = hiltViewModel()
) {
    val userDataResponse by userViewModel.getUserData.collectAsState()
    val userDeleteResponse by userViewModel.deleteUserData.collectAsState()
    val postDeleteResponse by userViewModel.postUserData.collectAsState()
    val updateDeleteResponse by userViewModel.updateUserData.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    //userViewModel.getUserData()
                   // userViewModel.deleteUserData(3)
                    val newTodo = UserPostData( todo = "Use green the user data for update the data from user side", completed = false, userId = 10)
                    //userViewModel.postUserData(newTodo)
                    userViewModel.updateUserData(3,newTodo)
                },
                colors = ButtonDefaults.buttonColors(),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Text("post Button")
            }
        }
        when (userDataResponse) {
            is ResourceState.Loader -> {
                Log.d("Home", " ********** loader ********** : ")
            }

            is ResourceState.Success -> {
                val response = (userDataResponse as ResourceState.Success).data
                if (response.todos.isNotEmpty()) {
                    Log.d("Home", " ********** Success ********** :${response.todos[0].todo} ")
                }
            }

            is ResourceState.Error -> {
                Log.d("Home", " ********** Error ********** : ")
            }
        }

        when (userDeleteResponse) {
            is ResourceState.Loader -> {
                Log.d("Home", " ********** loader ********** : ")
            }

            is ResourceState.Success -> {
                val response = (userDeleteResponse as ResourceState.Success).data
                if (response.isDeleted) {
                    Log.d("delete User Data", " ********** Success ********** :${response.todo} ")
                }
            }

            is ResourceState.Error -> {
                Log.d("Home", " ********** Error ********** : ")
            }
        }

        when (postDeleteResponse) {
            is ResourceState.Loader -> {
                Log.d("Home", " ********** loader ********** : ")
            }

            is ResourceState.Success -> {
                val response = (postDeleteResponse as ResourceState.Success).data
                if (response.completed) {
                    Log.d("delete User Data", " ********** Success ********** :${response.todo} ")
                }
            }

            is ResourceState.Error -> {
                Log.d("Home", " ********** Error ********** : ")
            }
        }

        when (updateDeleteResponse) {
            is ResourceState.Loader -> {
                Log.d("Home", " ********** loader ********** : ")
            }

            is ResourceState.Success -> {
                val response = (updateDeleteResponse as ResourceState.Success).data
                if (response.completed) {
                    Log.d("delete User Data", " ********** Success ********** :${response.todo} ")
                }
            }

            is ResourceState.Error -> {
                Log.d("Home", " ********** Error ********** : ")
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}