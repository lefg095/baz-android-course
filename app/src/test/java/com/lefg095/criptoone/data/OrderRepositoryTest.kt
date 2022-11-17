package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.OrderDao
import com.lefg095.criptoone.domain.model.Ask
import com.lefg095.criptoone.domain.model.Bid
import com.lefg095.criptoone.domain.model.Order
import com.lefg095.criptoone.domain.model.OrderResponse
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class OrderRepositoryTest{

    @Mock
    lateinit var orderDao: OrderDao
    @Mock
    lateinit var apiclient: ApiClient

    lateinit var orderRepository: OrderRepository

    val bookName = "btc_mxn"

    val order = Order(
        uid = 0,
        book = bookName
    )

    val ask = Ask(
            uid = 0,
            book = "btc_mxn",
            price = "5632.24",
            amount = "1.34491802"
        )

    val bid = Bid(
            uid = 0,
            book = "btc_mxn",
            price = "6123.55",
            amount = "1.12560000"
        )

    val orderResponse = OrderResponse(
            listOf(ask), listOf(bid)
        )

    @Before
    fun setup(){
        orderRepository = OrderRepository(apiclient, orderDao)
    }

    @Test
    fun `verify correct get api data`(){
        runBlocking {
            orderRepository.getExternalOrder(bookName)
            verify(apiclient).getOrders(bookName)
        }
    }

    @Test
    fun `verify correct get order local data`(){
        orderRepository.getLocalOrder(bookName)
        verify(orderDao).getOrder(bookName)
    }

    @Test
    fun `verify correct get ask local data`(){
        orderRepository.getLocalAsks(bookName)
        verify(orderDao).getAsks(bookName)
    }

    @Test
    fun `verify correct get bid local data`(){
        orderRepository.getLocalBids(bookName)
        verify(orderDao).getBids(bookName)
    }

    @Test
    fun `verify correct save order data`(){
        orderRepository.saveOrder(order, orderResponse)
        verify(orderDao).saveBid(orderResponse.bids)
        verify(orderDao).saveAsk(orderResponse.asks)
        verify(orderDao).saveOrder(order)
    }

    @Test
    fun `verify correct clean order data`(){
        orderRepository.cleanData(bookName)
        verify(orderDao).cleanBids(bookName)
        verify(orderDao).cleanAsks(bookName)
        verify(orderDao).cleanOrder(bookName)
    }

/*
{
    "success": true,
    "payload": {
        "asks": [{
            "book": "btc_mxn",
            "price": "5632.24",
            "amount": "1.34491802"
        },{
            "book": "btc_mxn",
            "price": "5633.44",
            "amount": "0.4259"
        },{
            "book": "btc_mxn",
            "price": "5642.14",
            "amount": "1.21642"
        }],
        "bids": [{
            "book": "btc_mxn",
            "price": "6123.55",
            "amount": "1.12560000"
        },{
            "book": "btc_mxn",
            "price": "6121.55",
            "amount": "2.23976"
        }],
        "updated_at": "2016-04-08T17:52:31.000+00:00",
        "sequence": "27214"
    }
}
 */

}