package com.lefg095.criptoone.domain.stateevent

import android.content.Context

sealed class BooksStateEvent {
    data class GetBooks(
        val context: Context
    ): BooksStateEvent()
}