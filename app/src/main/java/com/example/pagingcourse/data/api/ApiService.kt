package com.example.pagingcourse.data.api

import com.example.pagingcourse.data.model.ResponseApi
import com.example.pagingcourse.utils.Constance
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constance.end_point)
    suspend fun getAllCharacters(@Query("page") page: Int): Response<ResponseApi>
}