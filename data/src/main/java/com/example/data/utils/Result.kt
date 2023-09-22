package com.example.data.utils

sealed class Results<out T> {
    data class Success<out T>(val data: T?) : Results<T>()
    data class Error(val message: String) : Results<Nothing>()
    object Loadding : Results<Nothing>()

    fun toData(): T? = if (this is Success) data else null
}
