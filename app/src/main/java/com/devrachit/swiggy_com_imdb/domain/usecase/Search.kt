package com.devrachit.swiggy_com_imdb.domain.usecase

import com.devrachit.swiggy_com_imdb.data.remote.dto.Title
import com.devrachit.swiggy_com_imdb.data.remote.mapper.toSearchResult
import com.devrachit.swiggy_com_imdb.domain.model.SearchResult
import com.devrachit.swiggy_com_imdb.domain.repository.ApiServicesRepository
import com.devrachit.swiggy_com_imdb.utility.Resource
import com.devrachit.swiggy_com_imdb.utility.safeApiCall
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SearchTitleDetailsUseCase @Inject constructor(
    private val repository: ApiServicesRepository
){
    operator fun invoke(expression : String) : Flow<Resource<SearchResult>> = flow{
        emit(Resource.Loading())
        val response = safeApiCall { repository.searchTitles(expression).toSearchResult() }
        emit(response)

    }
}