package com.example.seekhoassignment.utils.networkUtil

sealed interface NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>
    data class Error(val message: String, val throwable: Throwable? = null) : NetworkResult<Nothing>
    data object Loading : NetworkResult<Nothing>
}
