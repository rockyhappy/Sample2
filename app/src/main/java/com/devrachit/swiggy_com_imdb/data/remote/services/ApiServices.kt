package com.devrachit.swiggy_com_imdb.data.remote.services

import com.devrachit.swiggy_com_imdb.data.remote.dto.SearchReasultDto
import com.devrachit.swiggy_com_imdb.data.remote.dto.Title
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {

    @GET("search/titles")
    suspend fun searchTitles(@Query("query") query: String): SearchReasultDto

    @GET("titles/{id}")
    suspend fun getTitleDetails(@Path("id") id: String): Title

}

