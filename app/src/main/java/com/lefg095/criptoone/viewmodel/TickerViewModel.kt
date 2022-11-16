package com.lefg095.criptoone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.domain.stateevent.TickerStateEvent
import com.lefg095.criptoone.domain.usecase.GetTickerUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class TickerViewModel
@Inject
constructor(
    private val tickerUseCaseImpl: GetTickerUseCaseImpl
): ViewModel(){

    private val _tickerResponse = MutableLiveData<DataState<BaseResponse<Ticker>>>()
    val tickerResponse: LiveData<DataState<BaseResponse<Ticker>>> get() = _tickerResponse

    fun makeApiCall(tickerStateEvent: TickerStateEvent){
        when(tickerStateEvent){
            is TickerStateEvent.GetTicker -> {
                viewModelScope.launch(Dispatchers.IO) {
                    tickerUseCaseImpl.invoke(
                        bookName = tickerStateEvent.nameBook,
                        context = tickerStateEvent.context
                    ).collect{
                        _tickerResponse.postValue(it)
                    }
                }
            }
        }
    }
}