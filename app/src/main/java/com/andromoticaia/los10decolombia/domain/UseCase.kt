package com.andromoticaia.los10decolombia.domain

import com.andromoticaia.los10decolombia.data.Repository
import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopArtist
import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopTrack

class UseCase(val repository: Repository) {

    suspend fun getTopArtist():ApiResponseTopArtist{
        return repository.getTopArtist()
    }

    suspend fun getTopTrack(artist: String):ApiResponseTopTrack{
        return repository.getTopTrack(artist)
    }
}