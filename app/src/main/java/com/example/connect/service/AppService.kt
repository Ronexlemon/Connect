package com.example.connect.service

import com.example.connect.model.MenAssets
import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET("")
   suspend fun getAll(): Response<List<MenAssets>>
}