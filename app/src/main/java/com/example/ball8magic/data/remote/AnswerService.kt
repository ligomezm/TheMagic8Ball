package com.example.ball8magic.data.remote

import retrofit2.http.GET

interface AnswerService {

    @GET("/JSON/\$question")
    suspend fun getAnswer(question: String) : AnswerApiModel
}