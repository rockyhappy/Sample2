package com.devrachit.swiggy_com_imdb.presentation.screens.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailsScreen(
    movieId: String,
    viewModel: DetailViewmodel,
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(true) {
        viewModel.getTitleDetails(movieId)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Movie ID: ${uiState.value.title.toString()}", modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(60.dp)
        )
    }

}