package com.lefg095.criptoone.domain.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lefg095.criptoone.domain.model.Ask
import com.lefg095.criptoone.domain.model.Bid
import com.lefg095.criptoone.domain.model.Order


@Dao
interface OrderDao {

    @Insert
    fun saveOrder(order: Order)

    @Insert
    fun saveAsk(askList: List<Ask>)

    @Insert
    fun saveBid(bidList: List<Bid>)

    @Query("SELECT * FROM order_table WHERE book = :bookName")
    fun getOrder(bookName: String): Order

    @Query("SELECT * FROM ask_table WHERE book = :bookName")
    fun getAsks(bookName: String): List<Ask>

    @Query("SELECT * FROM bid_table WHERE book = :bookName")
    fun getBids(bookName: String): List<Bid>

    @Query("DELETE FROM order_table WHERE book = :bookName")
    fun cleanOrder(bookName: String)

    @Query("DELETE FROM ask_table WHERE book = :bookName")
    fun cleanAsks(bookName: String)

    @Query("DELETE FROM bid_table WHERE book = :bookName")
    fun cleanBids(bookName: String)


}