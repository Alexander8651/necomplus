package com.andromoticaia.los10decolombia.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.andromoticaia.los10decolombia.domain.UseCase
import java.lang.Exception

class TopTrackViewmodel(private val useCase: UseCase) : ViewModel() {

    //obtiene la lista de canciones por artista
    fun getTopTrack(artist:String ) = liveData{
        try {

            val topTrack = useCase.getTopTrack(artist).toptracks
            emit(topTrack.track)

        }catch (e:Exception){

        }
    }
}