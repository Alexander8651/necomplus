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
import com.andromoticaia.los10decolombia.databinding.ItemtrackBinding
import com.andromoticaia.los10decolombia.model.apiResponse.Artist
import com.andromoticaia.los10decolombia.model.apiResponse.Track

class TrackAdapter : ListAdapter<Track, TrackAdapter.ViewHolder>(WorkShopDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TrackAdapter.ViewHolder, position: Int) {
        val track = getItem(position)
        holder.bind(track)
    }

    class ViewHolder private constructor(private val item: ItemtrackBinding) :
        RecyclerView.ViewHolder(item.root) {

        fun bind(track: Track){
            item.track = track
            item.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemtrackBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    class WorkShopDiffCallback : DiffUtil.ItemCallback<Track>() {
        override fun areItemsTheSame(
            oldItem: Track,
            newItem: Track
        ): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: Track,
            newItem: Track
        ): Boolean {
            return oldItem == newItem

        }

    }
}