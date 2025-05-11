package com.example.seekhoassignment.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface PokeMonApi {
    @GET("top/anime/")
    suspend fun getAnimeList(): Response<PokeMonListResponse?>
}