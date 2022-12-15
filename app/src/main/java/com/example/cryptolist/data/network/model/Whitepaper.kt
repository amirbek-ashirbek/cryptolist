package com.example.cryptolist.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Whitepaper(
    @Json(name = "link")
    val link: String?,
    @Json(name = "thumbnail")
    val thumbnail: String?
)