package com.example.ball8magic.data.remote

<<<<<<< HEAD
import retrofit2.
interface AnswerService {


=======
import retrofit2.http.GET

interface AnswerService {

    @GET("/JSON/\$question")
    suspend fun getAnswer(question: String) : AnswerApiModel
>>>>>>> origin/master
}