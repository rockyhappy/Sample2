package com.devrachit.swiggy_com_imdb.domain.model

import com.devrachit.swiggy_com_imdb.data.remote.dto.Title

data class SearchResult(
    val titles: List<Title>
)
