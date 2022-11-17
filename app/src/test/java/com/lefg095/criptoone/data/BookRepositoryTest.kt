package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.BookDao
import com.lefg095.criptoone.domain.model.Book
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BookRepositoryTest{

    @Mock
    lateinit var bookDao: BookDao
    @Mock
    lateinit var apiClient: ApiClient

    lateinit var bookRepository: BookRepository

    val bookCero =  Book(
            uid = 0,
            book = "btc_mxn",
            minimum_amount = ".003",
            maximum_amount = "1000.00",
            minimum_price = "100.00",
            maximum_price = "1000000.00",
            minimum_value = "25.00",
            maximum_value = "1000000.00"
        )

    val bookOne = Book(
            uid = 1,
            book = "eth_mxn",
            minimum_amount = ".003",
            maximum_amount = "1000.00",
            minimum_price = "100.0",
            maximum_price = "1000000.0",
            minimum_value = "25.0",
            maximum_value = "1000000.0"
        )

    val bookList = listOf(bookCero, bookOne)

    @Before
    fun setUp(){
        bookRepository = BookRepository(apiClient,bookDao)
    }

    @Test
    fun `verify book is clean`(){
        bookRepository.cleanBooks()
        verify(bookDao).cleanBooks()
    }

    @Test
    fun `verify correct get local data`(){
        bookRepository.getLocalBooks()
        verify(bookDao).getBook()
    }

    @Test
    fun `verify correct get api data`(){
        runBlocking {
            bookRepository.getExternalBooks()
            verify(apiClient).getBooks()
        }
    }

    @Test
    fun `verify correct save data`(){
        bookRepository.saveBooks(bookList)
        verify(bookDao).saveBooks(bookList)
    }
}