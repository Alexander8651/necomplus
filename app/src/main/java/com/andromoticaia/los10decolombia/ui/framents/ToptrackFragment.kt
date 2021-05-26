package com.andromoticaia.los10decolombia.ui.framents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.andromoticaia.los10decolombia.R
import com.andromoticaia.los10decolombia.data.RepositoryImpl
import com.andromoticaia.los10decolombia.databinding.FragmentToptrackBinding
import com.andromoticaia.los10decolombia.domain.UseCase
import com.andromoticaia.los10decolombia.model.apiResponse.Artist
import com.andromoticaia.los10decolombia.ui.activities.MainActivity
import com.andromoticaia.los10decolombia.ui.adapters.TrackAdapter
import com.andromoticaia.los10decolombia.viewmodel.TopTrackViewmodel
import com.andromoticaia.los10decolombia.viewmodel.VMFactory

class ToptrackFragment : Fragment() {

    lateinit var artist:Artist
    val viewModel by viewModels <TopTrackViewmodel> {
        VMFactory(UseCase(RepositoryImpl()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            //obtiene el artista enviado de el anterior fragment
            artist = it.getParcelable("artist")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inicializa el binding
        val binding = FragmentToptrackBinding.inflate(layoutInflater)
        context ?: binding.root

        val trackAdapter = TrackAdapter()

        //setea eltitulo del toolbar
        (activity as MainActivity).supportActionBar!!.title = "Top Canciones ${artist.name}"


        //observa y despliega la data en el recyclerview
        viewModel.getTopTrack(artist.name!!).observe(viewLifecycleOwner, {

            trackAdapter.submitList(it)
            binding.rvTopTrack.apply {
                adapter = trackAdapter
            }
        })



        return binding.root
    }
}