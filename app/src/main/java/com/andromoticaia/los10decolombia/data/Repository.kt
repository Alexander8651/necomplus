package com.andromoticaia.los10decolombia.data

import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopArtist
import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopTrack

interface Repository {

    suspend fun getTopArtist():ApiResponseTopArtist
    suspend fun getTopTrack(artist:String):ApiResponseTopTrack
}