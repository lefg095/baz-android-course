package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.TickerDao
import com.lefg095.criptoone.domain.model.Ticker
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class TickerRepositoryTest{

    @Mock
    lateinit var tickerDao: TickerDao
    @Mock
    lateinit var tickerApi: ApiClient

    lateinit var tickerRepository: TickerRepository

    val ticker = Ticker(   uid = 0,
        book = "btc_mxn",
        volume = "22.31349615",
        high = "5750.00",
        last = "5633.98",
        low = "5450.00",
        vwap = "5393.45",
        ask = "5632.24",
        bid = "5520.01",
        createdAt = "2016-04-08T17:52:31.000+00:00"
    )

    val bookName = "btc_mxn"

    @Before
    fun setUp(){
        tickerRepository = TickerRepository(tickerApi, tickerDao)
    }

    @Test
    fun `verify ticker is clean`(){
        tickerRepository.cleanTicker(bookName)
        verify(tickerDao).cleanTicker(bookName)
    }

    @Test
    fun `verify correct get local data`(){
        tickerRepository.getLocalticker(bookName)
        verify(tickerDao).getTicker(bookName)
    }

    @Test
    fun `verify correct get api data`(){
        runBlocking {
            tickerRepository.getExternalTicker(bookName)
            verify(tickerApi).getTicker(bookName)
        }
    }

    @Test
    fun `verify correct save data`(){
        tickerRepository.saveTicker(ticker)
        verify(tickerDao).saveTicker(ticker)
    }
}