package com.lefg095.criptoone.domain.stateevent

import android.content.Context

sealed class TickerStateEvent {
    data class GetTicker(
        val nameBook: String,
        val context: Context
    ): TickerStateEvent()

}
