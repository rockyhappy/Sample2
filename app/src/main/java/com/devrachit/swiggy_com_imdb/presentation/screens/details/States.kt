package com.devrachit.swiggy_com_imdb.presentation.screens.details

import com.devrachit.swiggy_com_imdb.data.remote.dto.Title

data class DetailUiState (
    val isLoading: Boolean ? = false,
    val title : Title ? = null,
)
