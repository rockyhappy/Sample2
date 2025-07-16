package com.devrachit.swiggy_com_imdb.domain.repository

import com.devrachit.swiggy_com_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_com_imdb.data.remote.dto.Title

interface ApiServicesRepository
{
    suspend fun searchTitles(title:String) : SearchReasultDto

    suspend fun getTitleDetails(imdbId:String) : Title
}