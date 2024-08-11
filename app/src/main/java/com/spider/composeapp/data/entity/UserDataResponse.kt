package com.spider.composeapp.data.entity

data class UserDataResponse(
    val todos: List<Todo>,
    val total: Long,
    val skip: Long,
    val limit: Long,
)

data class Todo(
    val id: Long,
    val todo: String,
    val completed: Boolean,
    val userId: Long,
)