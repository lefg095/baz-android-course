package com.lefg095.criptoone

import com.lefg095.criptoone.domain.BaseResponse
import com.lefg095.criptoone.domain.Book
import com.lefg095.criptoone.domain.DataState
import kotlinx.coroutines.flow.Flow

interface IBookRepository {
    fun getBooks(): Flow<DataState<BaseResponse>>
}