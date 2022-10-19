package com.lefg095.criptoone.di

import com.lefg095.criptoone.BookRepository
import com.lefg095.criptoone.IBookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepositor(apiService: ApiService): IBookRepository = BookRepository(apiService)
}