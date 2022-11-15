package com.lefg095.criptoone.data.interfaces

import com.lefg095.criptoone.domain.model.Order
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import kotlinx.coroutines.flow.Flow

interface IOrderRepository {

    fun getOrder(nameBook: String): Flow<DataState<BaseResponse<Order>>>

}
