package com.example.cryptolist.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stats(
    @Json(name = "contributors")
    val contributors: Int?,
    @Json(name = "followers")
    val followers: Int?,
    @Json(name = "stars")
    val stars: Int?,
    @Json(name = "subscribers")
    val subscribers: Int?
)