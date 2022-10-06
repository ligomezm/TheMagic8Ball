package com.example.data_remote.networking.answer

import com.squareup.moshi.Json

data class AnswerApiModel(
    @field:Json(name = "magic") val magic: Magic
    //    @Json(name = "magic") val magic : Magic
)

data class Magic(
    val question: String,
    val answer: String,
    val type: String
//    @Json(name = "question") val question : String,
//    @Json(name = "answer") val answer : String,
//    @Json(name = "type") val type : String
)


//{
//    "magic": {
//    "question": "Should I pay this employee",
//    "answer": "You may rely on it",
//    "type": "Affirmative"
//              }
//}