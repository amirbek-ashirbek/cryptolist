package com.example.cryptolist.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinksExtended(
    @Json(name = "stats")
    val stats: Stats?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "url")
    val url: String?
)