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
import com.lefg095.criptoone.domain.usecase.SaveTickerUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TickerViewModel
@Inject
constructor(
    private val getTickerUseCaseImpl: GetTickerUseCaseImpl,
    private val saveTickerUseCaseImpl: SaveTickerUseCaseImpl
): ViewModel(){

    private val _tickerResponse = MutableLiveData<DataState<BaseResponse<Ticker>>>()
    val tickerResponse: LiveData<DataState<BaseResponse<Ticker>>> get() = _tickerResponse

    fun makeApiCall(tickerStateEvent: TickerStateEvent){
        when(tickerStateEvent){
            is TickerStateEvent.GetTicker -> {
                viewModelScope.launch(Dispatchers.IO) {
                    getTickerUseCaseImpl.invoke(
                        bookName = tickerStateEvent.nameBook,
                        context = tickerStateEvent.context
                    ).collect{
                        _tickerResponse.postValue(it)
                    }
                }
            }

            is TickerStateEvent.SaveTicker -> {
                viewModelScope.launch(Dispatchers.IO) {
                    saveTickerUseCaseImpl.invoke(
                        ticker = tickerStateEvent.ticker
                    )
                }
            }
        }
    }


}