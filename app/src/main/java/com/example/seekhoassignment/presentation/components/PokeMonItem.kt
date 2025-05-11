package com.example.seekhoassignment.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.seekhoassignment.R
import com.example.seekhoassignment.domain.model.PokeMonUiState

@Composable
fun PokeMonItem(
    pokeMonListUiState: PokeMonUiState,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier.fillMaxWidth().clickable { onItemClick(pokeMonListUiState.id) },
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokeMonListUiState.posterImg)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build(),
                contentDescription = "pokeMon img",
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = pokeMonListUiState.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(500),
                    color = Color.White
                )
                Text(
                    text = "Episodes ${ pokeMonListUiState.numberOfEpisode}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Red
                )
                Text(
                    text = "Rating ${pokeMonListUiState.rating}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight(500),
                    color = Color.Cyan,
                )
            }
        }

    }
}