package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.BookDao
import com.lefg095.criptoone.domain.model.Book
import javax.inject.Inject

class BookRepository
@Inject
constructor(
        private val apiClient: ApiClient,
        private val bookDao: BookDao
    ) {

    suspend fun getExternalBooks() = apiClient.getBooks()

    fun getLocalBooks() = bookDao.getBook()

    fun saveBooks(books: List<Book>) {
        bookDao.saveBooks(books)
    }

    fun cleanBooks(){
        bookDao.cleanBooks()
    }

}