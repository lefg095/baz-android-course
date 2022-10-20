package com.lefg095.criptoone.di

import com.lefg095.criptoone.domain.BaseResponse
import com.lefg095.criptoone.domain.Book
import retrofit2.http.GET

interface ApiService {
    @GET("available_books/")
    suspend fun getBooks(
    ): BaseResponse
}
/*
https://api.bitso.com/v3/available_books/

https://api.bitso.com/v3/ticker/

https://api.bitso.com/v3/order_book/

*/