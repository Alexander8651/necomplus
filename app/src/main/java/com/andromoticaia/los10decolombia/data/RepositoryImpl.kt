package com.andromoticaia.los10decolombia.data

import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopArtist
import com.andromoticaia.los10decolombia.model.apiResponse.ApiResponseTopTrack
import com.andromoticaia.los10decolombia.network.RetrofitService

class RepositoryImpl :Repository {
    val api_key = "cf2894b9c73a323e24f5c6a9aab1eb85"
    val country = "colombia"
    var limit:Int? = null
    var method:String? = null
    val format="json"


    override suspend fun getTopArtist(): ApiResponseTopArtist {
        limit = 10
        method = "geo.gettopartists"
        return RetrofitService.retrofitService.getTopArtist(method!!,country,limit!!,api_key, format).await()
    }

    override suspend fun getTopTrack(artist:String): ApiResponseTopTrack {
        method = "artist.getTopTracks"
        limit = 5
        return RetrofitService.retrofitService.getTopTrack(method!!, artist, limit!!, api_key,format).await()
    }
}