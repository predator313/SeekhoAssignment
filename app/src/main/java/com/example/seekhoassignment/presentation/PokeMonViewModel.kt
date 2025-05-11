package com.example.seekhoassignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.domain.repository.PokeMonRepository
import com.example.seekhoassignment.utils.networkUtil.NetworkResult
import com.example.seekhoassignment.utils.networkUtil.safeApiCall
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokeMonViewModel @Inject constructor(
    private val pokeMonRepository: PokeMonRepository,
) : ViewModel() {

     fun getAnimeList() {
        viewModelScope.launch {
            when (val requestResult =  pokeMonRepository.getAnimeList()) {
                is NetworkResult.Error -> {
                    Timber.tag("hello").e("error ${requestResult.message}")
                }
                NetworkResult.Loading -> {
                    Timber.tag("hello").e("loading")
                }
                is NetworkResult.Success -> {
                    Timber.tag("hello").e("response ${requestResult.data}")
                }

            }
        }
    }
}