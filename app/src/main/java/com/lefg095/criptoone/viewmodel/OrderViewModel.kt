package com.lefg095.criptoone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lefg095.criptoone.domain.model.OrderResponse
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.domain.stateevent.OrderStateEvent
import com.lefg095.criptoone.domain.usecase.GetOrderUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OrderViewModel
@Inject
constructor(
    private val orderUseCaseImpl: GetOrderUseCaseImpl
): ViewModel(){

    private val _orderResponse = MutableLiveData<DataState<BaseResponse<OrderResponse>>>()
    val orderResponse: LiveData<DataState<BaseResponse<OrderResponse>>> get() = _orderResponse

    fun makeApiCall(orderStateEvent: OrderStateEvent){
        when(orderStateEvent){
            is OrderStateEvent.GetOrder -> {
                viewModelScope.launch(Dispatchers.IO) {
                    async {
                        orderUseCaseImpl.invoke(
                                context = orderStateEvent.context,
                                nameBook = orderStateEvent.nameBook
                            ).collect {
                                _orderResponse.postValue(it)
                            }
                    }
                }
            }
        }
    }
}