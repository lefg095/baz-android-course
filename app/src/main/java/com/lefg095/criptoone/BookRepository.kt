package com.lefg095.criptoone

import com.lefg095.criptoone.domain.BaseResponse
import com.lefg095.criptoone.domain.Book
import com.lefg095.criptoone.domain.DataState
import com.lefg095.criptoone.di.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BookRepository(
    private val apiService: ApiService
) : IBookRepository {

    override fun getBooks(
    ): Flow<DataState<BaseResponse>> = flow {
        emit(DataState.Loading("Cargando Libros..."))
        try{
            val response = apiService.getBooks()
            emit(DataState.Success(response))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }
    }

}