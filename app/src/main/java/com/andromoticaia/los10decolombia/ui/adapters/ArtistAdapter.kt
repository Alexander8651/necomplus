package com.andromoticaia.los10decolombia.ui.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.andromoticaia.los10decolombia.R
import com.andromoticaia.los10decolombia.databinding.ItemartistBinding
import com.andromoticaia.los10decolombia.model.apiResponse.Artist

class ArtistAdapter: ListAdapter<Artist, ArtistAdapter.ViewHolder>(WorkShopDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ArtistAdapter.ViewHolder, position: Int) {
        val artist = getItem(position)
        holder.bind(artist)
    }

    class ViewHolder private constructor(private val item: ItemartistBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(artist: Artist){
            item.artist = artist
            item.executePendingBindings()

            itemView.setOnClickListener {

                val bundle = Bundle()

                bundle.putParcelable("artist", artist)

                //navega y envia el artista al siguiente fragment
                it.findNavController().navigate(R.id.action_topArtistFragment_to_toptrackFragment, bundle)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemartistBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    class WorkShopDiffCallback : DiffUtil.ItemCallback<Artist>() {
        override fun areItemsTheSame(
            oldItem: Artist,
            newItem: Artist
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Artist,
            newItem: Artist
        ): Boolean {
            return oldItem == newItem

        }

    }
}
