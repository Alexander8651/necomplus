package com.andromoticaia.los10decolombia.model.apiResponse

data class Track(
    val name: String? = null,
    val playcount: String? = null,
    val listeners: String? = null,
    val mbid: String? = null,
    val url: String? = null,
    val streamable: String? = null,
    val image: List<Image>
)