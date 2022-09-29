package com.example.data_remote

import com.example.data_remote.networking.answer.AnswerApiModel
import com.example.data_remote.networking.answer.AnswerService
import com.example.data_remote.networking.answer.Magic
import com.example.data_remote.source.RemoteAnswerDataSourceImpl
import com.example.domain.entity.Answer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class RemoteAnswerDataSourceImplTest {
    private val answerService = mock<AnswerService>()
    private val answerDataSource = RemoteAnswerDataSourceImpl(answerService)

    @ExperimentalCoroutinesApi
    @Test
    fun testGetAnswer() = runTest {
        val remoteAnswers = listOf(AnswerApiModel(Magic("your question", "the answer", "")))
        val expectedAnswer = listOf(Answer("the answer", "your question", ""))
        whenever(answerService.getAnswer("your question")).thenReturn(remoteAnswers)
        val result = answerDataSource.getAnswer("your question").first()
        Assert.assertEquals(expectedAnswer, result)
    }
}