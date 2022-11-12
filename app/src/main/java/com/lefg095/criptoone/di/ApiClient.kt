package com.lefg095.criptoone.di

import com.lefg095.criptoone.domain.model.Book
import com.lefg095.criptoone.domain.model.Order
import com.lefg095.criptoone.domain.model.OrderResponse
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.response.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiClient {
    @GET("available_books/")
    suspend fun getBooks(
    ): BookResponse<Book>

    @GET("ticker/")
    suspend fun getTicker(
        @Query("book") nameBook: String
    ): BaseResponse<Ticker>

    @GET("order_book/")
    suspend fun getOrders(
        @Query("book") nameBook: String
    ): BaseResponse<OrderResponse>
}