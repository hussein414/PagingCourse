package com.example.pagingcourse.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingcourse.data.repository.RickAndMortyRepository
import com.example.pagingcourse.ui.source.RickAndMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(repository: RickAndMortyRepository) : ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 1)) {
        RickAndMortyPagingSource(repository = repository)
    }.flow.cachedIn(viewModelScope)

}