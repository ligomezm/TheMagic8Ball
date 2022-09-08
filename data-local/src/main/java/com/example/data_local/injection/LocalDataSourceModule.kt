package com.example.data_local.injection

import com.example.data_local.source.LocalAnswerDataSourceImpl
import com.example.data_repository.data_source.local.LocalAnswerDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {
    @Binds
    abstract fun bindAnswerDataSource(answerDataSource: LocalAnswerDataSourceImpl): LocalAnswerDataSource
}