package com.example.connect.service


import com.example.connect.constants.AppConstants.EndPoint

import com.example.connect.model.MenAsset
import com.example.connect.model.MenAsstes
import com.example.connect.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface AppService {
    @GET(EndPoint)
   suspend fun getAll(): Response<List<Products>>
}