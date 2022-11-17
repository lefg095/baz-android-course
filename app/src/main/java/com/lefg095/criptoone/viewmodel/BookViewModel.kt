package com.lefg095.criptoone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lefg095.criptoone.domain.model.Book
import com.lefg095.criptoone.domain.response.BookResponse
import com.lefg095.criptoone.domain.stateevent.BooksStateEvent
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.domain.usecase.GetBookUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BookViewModel
@Inject
constructor(
    private val bookUseCaseImpl: GetBookUseCaseImpl
): ViewModel() {

    private val _booksResponse = MutableLiveData<DataState<BookResponse<Book>>>()
    val bookResponse: LiveData<DataState<BookResponse<Book>>> get() = _booksResponse

    fun makeApiCall(booksStateEvent: BooksStateEvent){
        when(booksStateEvent){
            is BooksStateEvent.GetBooks -> {
                viewModelScope.launch {
                    withContext(Dispatchers.IO) {
                        bookUseCaseImpl.invoke(
                            context = booksStateEvent.context
                        ).collect {
                            _booksResponse.postValue(it)
                        }
                    }
                }
            }
        }
    }
}