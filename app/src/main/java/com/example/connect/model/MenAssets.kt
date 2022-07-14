package com.example.connect.model

import com.example.connect.R

data class MenAsset(val image:Int?=null, val description:String?=null, val price: Double )
data class MenAsstes(
    val results :MutableList<MenAsset>
)