package com.example.seekhoassignment.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seekhoassignment.data.mapper.toPokeMonListUiState
import com.example.seekhoassignment.domain.model.PokeMonUiState
import com.example.seekhoassignment.domain.repository.PokeMonRepository
import com.example.seekhoassignment.utils.networkUtil.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeMonViewModel @Inject constructor(
    private val pokeMonRepository: PokeMonRepository,
) : ViewModel() {

    init {
        getAnimeList()
    }

    private val _pokeMonListUiStateFlow = MutableStateFlow<List<PokeMonUiState>>(emptyList())
    val pokeMonListUiStateFlow = _pokeMonListUiStateFlow.asStateFlow()
    private fun getAnimeList() {
        viewModelScope.launch {
            when (val requestResult =  pokeMonRepository.getAnimeList()) {
                is NetworkResult.Success -> {
                   _pokeMonListUiStateFlow.update {
                       val response = requestResult.data
                       response?.toPokeMonListUiState() ?: emptyList()
                   }
                }

                else -> {}
            }
        }
    }
}