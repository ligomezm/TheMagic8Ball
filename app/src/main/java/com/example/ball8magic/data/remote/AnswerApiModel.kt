package com.example.ball8magic.data.remote

import com.squareup.moshi.Json

data class AnswerApiModel(
    @Json(name = "magic") val magic : Magic
)

data class Magic(
    @Json(name = "question") val question : String,
    @Json(name = "answer") val answer : String,
    @Json(name = "type") val type : String
)