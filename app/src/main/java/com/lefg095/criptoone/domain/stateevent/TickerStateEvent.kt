package com.lefg095.criptoone.domain.stateevent

import android.content.Context
import com.lefg095.criptoone.domain.model.Ticker

sealed class TickerStateEvent {
    data class GetTicker(
        val nameBook: String,
        val context: Context
    ): TickerStateEvent()

    data class SaveTicker(
        val ticker: Ticker
    ): TickerStateEvent()

}
