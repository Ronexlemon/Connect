package com.example.connect.service

import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET("")
    fun getAll(): Response<List<String>>
}