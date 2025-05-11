package com.example.seekhoassignment.data.repository

import com.example.seekhoassignment.data.remote.PokeMonApi
import com.example.seekhoassignment.data.remote.PokeMonListResponse
import com.example.seekhoassignment.domain.repository.PokeMonRepository
import com.example.seekhoassignment.utils.networkUtil.NetworkResult
import com.example.seekhoassignment.utils.networkUtil.safeApiCall
import javax.inject.Inject

class PokeMonRepositoryImpl @Inject constructor(private val api: PokeMonApi) : PokeMonRepository {
    override suspend fun getAnimeList(): NetworkResult<PokeMonListResponse?> {
        return safeApiCall { api.getAnimeList() }
    }
}