package com.spider.utilities

sealed class ResourceState<T> {

    class Loader<T> : ResourceState<T>()
    data class Success<T>(val data: T) : ResourceState<T>()
    data class Error<T>(val error: Any) : ResourceState<T>()

}