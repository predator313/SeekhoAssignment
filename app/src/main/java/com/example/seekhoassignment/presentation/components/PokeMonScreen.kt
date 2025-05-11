package com.example.seekhoassignment.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.seekhoassignment.domain.model.PokeMonUiState

@Composable
fun PokeMonScreen(
    pokeMonListUiState: List<PokeMonUiState>,
    modifier: Modifier = Modifier
) {
    var openDetailScreen by remember { mutableStateOf(false) }
    var pokeMonId by remember { mutableIntStateOf(0) }
    if (pokeMonListUiState.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            FullScreenLoader(modifier = Modifier.size(100.dp))
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp),

        ) {
            items(
                pokeMonListUiState,
                key = { it.id }
            ) { item ->
                PokeMonItem(
                    pokeMonListUiState = item,
                    modifier = Modifier.fillMaxWidth(),
                    onItemClick = {
                        pokeMonId = it
                        openDetailScreen = true
                    }
                )
            }
        }
    }

    val selectedPokeMon = pokeMonListUiState.find { it.id == pokeMonId }?: PokeMonUiState()


    if (openDetailScreen) {
        PokeMonDetailScreen(
            pokeMonUiState = selectedPokeMon,
            modifier = Modifier.fillMaxSize(),
            onBackClick =  remember{ {  openDetailScreen = false}},
            onDismiss = remember{{openDetailScreen = false}}
        )
    }
}