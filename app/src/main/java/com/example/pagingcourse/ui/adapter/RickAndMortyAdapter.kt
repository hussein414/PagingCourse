package com.example.pagingcourse.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.pagingcourse.data.model.RickAndMorty
import com.example.pagingcourse.databinding.ItemCardBinding
import com.example.pagingcourse.utils.Constance

class RickAndMortyAdapter :
    PagingDataAdapter<RickAndMorty, RickAndMortyViewHolder>(Constance.diffCallback) {
    override fun onBindViewHolder(holder: RickAndMortyViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bindViews(currentItem!!)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RickAndMortyViewHolder =
        RickAndMortyViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}