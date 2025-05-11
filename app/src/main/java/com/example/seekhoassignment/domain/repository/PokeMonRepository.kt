package com.example.seekhoassignment.domain.repository

import com.example.seekhoassignment.data.remote.PokeMonListResponse
import com.example.seekhoassignment.utils.networkUtil.NetworkResult

interface PokeMonRepository {
    suspend fun getAnimeList(): NetworkResult<PokeMonListResponse?>
}