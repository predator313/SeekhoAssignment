package com.example.seekhoassignment.data.mapper

import com.example.seekhoassignment.data.remote.PokeMonListResponse
import com.example.seekhoassignment.domain.model.PokeMonUiState

fun PokeMonListResponse.toPokeMonListUiState(): List<PokeMonUiState> {
    return this.data.mapNotNull { pokeMonItem ->
        pokeMonItem?.let {
            PokeMonUiState(
                id = it.id ?: 0,
                title = it.title.orEmpty(),
                numberOfEpisode = it.numberOfEpisode ?: 0,
                rating = it.rating ?: 0f,
                posterImg = it.posterImg?.jpg?.imageUrl,
                genres = it.genres?.map { genre ->
                    genre.name
                } ?: emptyList(),
                casts = it.mainCast?.map { cast ->
                    cast.name
                } ?: emptyList(),
                plot = it.synopsis ?: "",
                trailer = it.trailer?.url,
            )
        }
    }
}
