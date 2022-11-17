package com.lefg095.criptoone.domain.usecase

import com.lefg095.criptoone.data.TickerRepository
import com.lefg095.criptoone.domain.model.Ticker
import javax.inject.Inject

class SaveTickerUseCaseImpl
@Inject
constructor(
    private val repository: TickerRepository
){

    operator fun invoke(ticker: Ticker) {
        try {
            repository.cleanTicker(ticker.book)
            repository.saveTicker(ticker)
        }catch (e: Exception){

        }
    }
}