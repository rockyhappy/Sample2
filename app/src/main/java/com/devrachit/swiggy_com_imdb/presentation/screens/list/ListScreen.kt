package com.devrachit.swiggy_com_imdb.presentation.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListScreen(
    viewmodel: ListScreenViewmodel,
    navigateToDetail: (movieId: String) -> Unit
) {
    val uiState = viewmodel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        viewmodel.getSearchResults("The")
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        if (uiState.value.list == null) {
            item {
                Text(text = "Loading...")
            }

        } else {
            items(
                count = uiState.value.list.titles.size,
                key = { index -> uiState.value.list.titles[index].id })
            { index ->
                Text(
                    text = uiState.value.list.titles[index].toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(60.dp)
                        .clickable{navigateToDetail(uiState.value.list.titles[index].id)}
                )
            }


        }

    }
}