package com.example.connect.apprepository

import com.example.connect.service.AppService
import javax.inject.Inject

class AppRepository
@Inject constructor(private val service:AppService){
    suspend fun  getData() =  service.getAll()
}