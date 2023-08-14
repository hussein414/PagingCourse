package com.example.pagingcourse.data.repository

import com.example.pagingcourse.data.api.ApiService
import javax.inject.Inject


class RickAndMortyRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getAllCharacters(page: Int) = apiService.getAllCharacters(page)
}