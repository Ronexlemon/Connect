package com.example.connect.model

data class Products(
    val id: Int,
    val productDescription: String?=null,
    val productImageUrl: String?=null,
    val productName: String?=null,
    val productPrice: Double
)
