package com.andromoticaia.los10decolombia.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.andromoticaia.los10decolombia.domain.UseCase
import java.lang.Exception

class TopArtistViewModel(private val useCase: UseCase) : ViewModel() {

    //ontiene el p delos artistas 10
    val topArtist = liveData {
        try {

            val topArtist = useCase.getTopArtist()

            emit(topArtist.topartists!!.artist)

        }catch (e:Exception){
        }
    }

}