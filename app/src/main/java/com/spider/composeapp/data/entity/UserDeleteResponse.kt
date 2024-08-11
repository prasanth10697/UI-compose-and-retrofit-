package com.spider.composeapp.data.entity

data class UserDeleteResponse(
    val id: Long,
    val todo: String,
    val completed: Boolean,
    val userId: Long,
    val isDeleted: Boolean,
    val deletedOn: String,
)
