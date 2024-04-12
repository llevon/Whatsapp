package com.example.whatsapp.utils

sealed class Resource<out T> {

    data class Success<T>(val model: T): Resource<T>()
    data class Error<T>(val throwable: Throwable, val model: T? = null): Resource<T>()
    data object Loading: Resource<Nothing>()

}