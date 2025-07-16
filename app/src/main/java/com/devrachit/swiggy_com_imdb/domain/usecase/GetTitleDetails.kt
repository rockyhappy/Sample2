package com.devrachit.swiggy_com_imdb.domain.usecase

import com.devrachit.swiggy_com_imdb.data.remote.dto.Title
import com.devrachit.swiggy_com_imdb.domain.repository.ApiServicesRepository
import com.devrachit.swiggy_com_imdb.utility.Resource
import com.devrachit.swiggy_com_imdb.utility.safeApiCall
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetTitleDetails @Inject constructor(
    private val repository: ApiServicesRepository
){
    operator fun invoke(id: String) : Flow<Resource<Title>> = flow{
        emit(Resource.Loading())
        val response = safeApiCall { repository.getTitleDetails(id) }
        emit ( response)
    }
}