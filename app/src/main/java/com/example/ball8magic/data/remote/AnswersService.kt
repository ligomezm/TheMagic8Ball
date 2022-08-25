package com.example.ball8magic.data.remote

interface AnswersService {
    @GET("/JSON")
    suspend fun getAnswer(question: String)
}