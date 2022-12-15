package com.example.cryptolist.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "coin_counter")
    val coinCounter: Int?,
    @Json(name = "ico_counter")
    val icoCounter: Int?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?
)