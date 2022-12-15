package com.example.cryptolist.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "explorer")
    val explorer: List<String?>?,
    @Json(name = "facebook")
    val facebook: List<String?>?,
    @Json(name = "reddit")
    val reddit: List<String?>?,
    @Json(name = "source_code")
    val sourceCode: List<String?>?,
    @Json(name = "website")
    val website: List<String?>?,
    @Json(name = "youtube")
    val youtube: List<String?>?
)