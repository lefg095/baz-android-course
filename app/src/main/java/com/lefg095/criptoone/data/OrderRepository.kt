package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.OrderDao
import com.lefg095.criptoone.domain.model.Order
import com.lefg095.criptoone.domain.model.OrderResponse
import javax.inject.Inject

class OrderRepository
@Inject constructor(
    private val apiClient: ApiClient,
    private val orderDao: OrderDao
) {

    suspend fun getExternalOrder(nameBook: String) = apiClient.getOrders(nameBook = nameBook)

    fun getLocalOrder(nameBook: String) = orderDao.getOrder(bookName = nameBook)

    fun getLocalAsks(nameBook: String) = orderDao.getAsks(bookName = nameBook)

    fun getLocalBids(nameBook: String) = orderDao.getBids(bookName = nameBook)

    fun saveOrder(order: Order, orderResponse: OrderResponse) {
        orderDao.saveOrder(order = order)
        orderDao.saveAsk(askList = orderResponse.asks)
        orderDao.saveBid(bidList = orderResponse.bids)
    }

    fun cleanData(bookName: String) {
        orderDao.cleanOrder(bookName = bookName)
        orderDao.cleanAsks(bookName = bookName)
        orderDao.cleanBids(bookName = bookName)
    }
}
