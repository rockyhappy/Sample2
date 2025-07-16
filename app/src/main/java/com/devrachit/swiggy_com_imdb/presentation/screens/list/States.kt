package com.devrachit.swiggy_com_imdb.presentation.screens.list

import com.devrachit.swiggy_com_imdb.domain.model.SearchResult

data class States (
    var isLoading: Boolean = false,
    var list : SearchResult = SearchResult(emptyList()),
)