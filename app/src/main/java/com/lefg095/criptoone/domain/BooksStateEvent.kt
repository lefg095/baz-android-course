package com.lefg095.criptoone.domain

sealed class BooksStateEvent {
    object GetBooks : BooksStateEvent()
}