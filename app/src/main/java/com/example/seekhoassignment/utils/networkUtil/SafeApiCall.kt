package com.example.seekhoassignment.utils.networkUtil

import retrofit2.Response

suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                NetworkResult.Success(it)
            } ?: NetworkResult.Error("Empty response body")
        } else {
            NetworkResult.Error("Error code ${response.code()}: ${response.message()}")
        }
    } catch (e: Exception) {
        NetworkResult.Error("Network error: ${e.localizedMessage}", e)
    }
}

