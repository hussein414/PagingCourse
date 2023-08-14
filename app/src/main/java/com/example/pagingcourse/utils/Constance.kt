package com.example.pagingcourse.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.pagingcourse.data.model.RickAndMorty

object Constance {
    const val base_url = "https://rickandmortyapi.com/api/"
    const val end_point = "character"

    val diffCallback = object : DiffUtil.ItemCallback<RickAndMorty>() {
        override fun areItemsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: RickAndMorty, newItem: RickAndMorty): Boolean =
            oldItem == newItem
    }
}