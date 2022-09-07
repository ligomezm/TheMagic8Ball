package com.example.data_remote.networking.answer

import com.squareup.moshi.Json

data class AnswerApiModel(
    @Json(name = "magic") val magic : Magic
)

data class Magic(
    @Json(name = "question") val question : String,
    @Json(name = "answer") val answer : String,
    @Json(name = "type") val type : String
)


//{
//    "magic": {
//    "question": "Should I pay this employee",
//    "answer": "You may rely on it",
//    "type": "Affirmative"
//              }
//}