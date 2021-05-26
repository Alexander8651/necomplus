package com.andromoticaia.los10decolombia.network

import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopArtist
import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopTrack
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("?")
    fun getTopArtist(
        @Query("method") method: String,
        @Query("country") country: String,
        @Query("limit") limit: Int,
        @Query("api_key") api_key: String,
        @Query("format") format:String
    ): Deferred<ApiResponseTopArtist>

    @GET("?")
    fun getTopTrack(
        @Query("method") method: String,
        @Query("artist") artist: String,
        @Query("limit") limit: Int,
        @Query("api_key") api_key: String,
        @Query("format") format:String

    ): Deferred<ApiResponseTopTrack>
}