package com.lefg095.criptoone.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lefg095.criptoone.domain.model.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveBooks(books: List<Book>)

    @Query("SELECT * FROM book_table")
    fun getBook(): List<Book>

    @Query("DELETE FROM book_table")
    fun cleanBooks()

}