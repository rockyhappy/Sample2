package com.devrachit.swiggy_com_imdb.data.remote.mapper

import com.devrachit.swiggy_com_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_com_imdb.domain.model.SearchResult

fun SearchReasultDto.toSearchResult(): SearchResult
{
    return SearchResult(
        titles = this.titles
    )
}