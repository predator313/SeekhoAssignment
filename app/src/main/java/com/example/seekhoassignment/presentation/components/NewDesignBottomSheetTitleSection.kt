package com.example.seekhoassignment.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.seekhoassignment.R

@Composable
fun NewDesignBottomSheetTitleSection(
    title: String,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
) {
    Row(
        modifier = modifier.padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable {
                        onBackClick()
                    },
                painter = painterResource(id = R.drawable.ic_left_arrow_new_design),
                contentDescription = "Back"
            )
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = title,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
            )
        }
    }
}