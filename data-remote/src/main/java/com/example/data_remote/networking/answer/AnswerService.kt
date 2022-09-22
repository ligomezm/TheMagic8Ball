package com.example.data_remote.networking.answer

import retrofit2.http.GET

interface AnswerService {

    @GET("JSON/\$question")
    suspend fun getAnswer(question: String) : List<AnswerApiModel>

}