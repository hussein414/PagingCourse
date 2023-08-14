package com.example.pagingcourse.ui.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.pagingcourse.data.model.RickAndMorty
import com.example.pagingcourse.databinding.ItemCardBinding

class RickAndMortyViewHolder(private val binding: ItemCardBinding) : ViewHolder(binding.root) {
    fun bindViews(model: RickAndMorty) {
        binding.apply {
            image.load(model.image) {
                crossfade(true)
                crossfade(1000)
            }
            name.text = model.name
        }
    }
}