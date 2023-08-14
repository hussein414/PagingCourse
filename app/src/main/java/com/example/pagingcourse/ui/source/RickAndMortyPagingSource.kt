package com.example.pagingcourse.ui.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pagingcourse.data.model.RickAndMorty
import com.example.pagingcourse.data.repository.RickAndMortyRepository
import kotlin.Exception

class RickAndMortyPagingSource(private val repository: RickAndMortyRepository) :
    PagingSource<Int, RickAndMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickAndMorty>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickAndMorty> = try {
        val currentPage = params.key ?: 1
        val response = repository.getAllCharacters(currentPage)
        val data = response.body()?.rickAndMorty ?: emptyList()
        val responseData= mutableListOf<RickAndMorty>()
        responseData.addAll(data)
        LoadResult.Page(
            data = responseData,
            prevKey = if (currentPage==1)null else -1,
            nextKey = currentPage.plus(1)
        )
    } catch (e: Exception) {
        LoadResult.Error(e)
    }
}