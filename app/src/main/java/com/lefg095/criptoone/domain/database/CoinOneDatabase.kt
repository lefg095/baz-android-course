package com.lefg095.criptoone.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lefg095.criptoone.domain.dao.BookDao
import com.lefg095.criptoone.domain.dao.OrderDao
import com.lefg095.criptoone.domain.dao.TickerDao
import com.lefg095.criptoone.domain.model.*

@Database(entities = [Book::class, Ticker::class,
            Order::class, Bid::class, Ask::class]
    , version = 6, exportSchema = false)
abstract class CoinOneDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao

    abstract fun tickerDao(): TickerDao

    abstract fun orderDao(): OrderDao
}