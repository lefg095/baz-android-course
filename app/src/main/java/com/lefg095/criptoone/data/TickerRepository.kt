package com.lefg095.criptoone.data

import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.TickerDao
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import rx.Observable
import javax.inject.Inject

class TickerRepository
@Inject
constructor(
    private val apiClient: ApiClient,
    private val tickerDao: TickerDao
) {

    suspend fun getExternalTicker(nameBook: String) = apiClient.getTicker(nameBook = nameBook)

    fun getExternalTickerObs(nameBook: String): Observable<BaseResponse<Ticker>> {
        return apiClient.getTickerObs(nameBook)
    }

    fun getLocalticker(nameBook: String) = tickerDao.getTicker(bookName = nameBook)

    fun saveTicker(ticker: Ticker) {
        tickerDao.saveTicker(ticker = ticker)
    }

    fun cleanTicker(bookName: String) {
        tickerDao.cleanTicker(bookName = bookName)
    }

}