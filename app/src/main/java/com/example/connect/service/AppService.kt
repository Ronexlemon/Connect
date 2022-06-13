package com.example.connect.service


import com.example.connect.model.MenAsset
import com.example.connect.model.MenAsstes
import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET("")
   suspend fun getAll(): Response<MenAsstes>
}