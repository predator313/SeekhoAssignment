package com.example.seekhoassignment.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.seekhoassignment.R
import com.example.seekhoassignment.domain.model.PokeMonUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokeMonDetailScreen(
    pokeMonUiState: PokeMonUiState,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    ModalBottomSheet(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.background,
        shape = RectangleShape,
        scrimColor = Color(0xE5333333),
        dragHandle = {
            NewDesignBottomSheetTitleSection(
                title = "Title ${pokeMonUiState.title}",
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.safeContent.only(WindowInsetsSides.Vertical)),
                onBackClick = onBackClick,
            )
        },
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true
        ),
        onDismissRequest = onDismiss
    ) {
        Column(
            modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokeMonUiState.posterImg)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .crossfade(true)
                    .build(),
                contentDescription = "pokeMon img",
                contentScale = ContentScale.Crop,

            )

            Text(
                text = pokeMonUiState.plot,
                fontWeight = FontWeight(500),
                color = Color.White,
                fontSize = 16.sp,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text ="Genres ${pokeMonUiState.genres.take(3).toString().split(',')}",

            )

            Text(
                text ="Cast ${pokeMonUiState.casts.take(3).toString().split(',')}",
            )

            Text(
                text = "number of episode ${pokeMonUiState.numberOfEpisode}"
            )
            Text(
                text = "Rating ${pokeMonUiState.rating}"
            )
        }
    }

}