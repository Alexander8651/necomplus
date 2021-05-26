package com.andromoticaia.los10decolombia.ui.framents

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.andromoticaia.los10decolombia.data.RepositoryImpl
import com.andromoticaia.los10decolombia.databinding.FragmentTopArtistBinding
import com.andromoticaia.los10decolombia.domain.UseCase
import com.andromoticaia.los10decolombia.ui.adapters.ArtistAdapter
import com.andromoticaia.los10decolombia.viewmodel.TopArtistViewModel
import com.andromoticaia.los10decolombia.viewmodel.VMFactory

class TopArtistFragment : Fragment() {

    val viewmodel by viewModels<TopArtistViewModel> {
        VMFactory(UseCase(RepositoryImpl()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inicializa el binding
        val binding = FragmentTopArtistBinding.inflate(layoutInflater)
        context ?: binding.root

        val artistAdapter = ArtistAdapter()

        //observa y despliega la data en el recyclerview

        viewmodel.topArtist.observe(viewLifecycleOwner, {
            artistAdapter.submitList(it)

            binding.rvTopArtist.apply {
                adapter = artistAdapter
            }

        })


        return binding.root
    }
}