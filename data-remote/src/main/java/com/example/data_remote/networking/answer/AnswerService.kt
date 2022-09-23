package com.example.data_remote.networking.answer

import retrofit2.http.GET
import retrofit2.http.Path

interface AnswerService {

    @GET("JSON/{question}")
    suspend fun getAnswer(@Path("question") question: String) : List<AnswerApiModel>

}