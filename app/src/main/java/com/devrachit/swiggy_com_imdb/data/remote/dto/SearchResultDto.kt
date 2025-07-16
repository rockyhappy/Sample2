package com.devrachit.swiggy_com_imdb.data.remote.dto


import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class SearchReasultDto(
    val titles: List<Title>
)

@Serializable
data class Title(
    val id: String,
    val type: String,
    val primaryTitle: String,
    val primaryImage: Image? = null,
    val genres: List<String>? = null,
    val startYear: Int? = null,
    val runtimeSeconds: Int? = null,
    val plot: String? = null,
    val originCountries: List<Country>? = null,
    val spokenLanguages: List<Language>? = null,
    val rating: Rating? = null
):  java.io.Serializable

@Serializable
data class Image(
    val url: String,
    val width: Int?,
    val height: Int?
)

@Serializable
data class Country(
    val code: String,
    val name: String
)

@Serializable
data class Language(
    val code: String,
    val name: String
)

@Serializable
data class Rating(
    val aggregateRating: Double,
    val voteCount: Int
)
