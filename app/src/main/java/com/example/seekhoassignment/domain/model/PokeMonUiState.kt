package com.example.seekhoassignment.domain.model

data class PokeMonUiState(
    val id: Int = 0,
    val title: String = "",
    val numberOfEpisode: Int = 0,
    val rating: Float = 0.0f,
    val posterImg:String? = null,
    val genres: List<String> = emptyList(),
    val casts: List<String> = emptyList(),
    val plot: String = "",
    val trailer: String? = null
)
