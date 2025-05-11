package com.example.seekhoassignment.domain.model

data class PokeMonUiState(
    val id: Int,
    val title: String,
    val numberOfEpisode: Int,
    val rating: Float,
    val posterImg:String? = null,
)
