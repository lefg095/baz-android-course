package com.lefg095.criptoone.domain.stateevent

import android.content.Context


sealed class OrderStateEvent {
    data class GetOrder(
        val nameBook: String,
        val context: Context
    ): OrderStateEvent()

}
