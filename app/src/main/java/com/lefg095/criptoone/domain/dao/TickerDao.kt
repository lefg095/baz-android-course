package com.lefg095.criptoone.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lefg095.criptoone.domain.model.Ticker

@Dao
interface TickerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTicker(ticker: Ticker)

    @Query("SELECT * FROM ticker_table WHERE book = :bookName")
    fun getTicker(bookName: String): Ticker

    @Query("DELETE FROM ticker_table WHERE book = :bookName")
    fun cleanTicker(bookName: String)

}