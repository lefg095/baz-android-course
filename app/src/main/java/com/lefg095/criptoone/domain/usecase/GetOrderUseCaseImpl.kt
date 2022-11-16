package com.lefg095.criptoone.domain.usecase

import android.content.Context
import com.lefg095.criptoone.data.OrderRepository
import com.lefg095.criptoone.domain.model.Ask
import com.lefg095.criptoone.domain.model.Bid
import com.lefg095.criptoone.domain.model.Order
import com.lefg095.criptoone.domain.model.OrderResponse
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.util.isConnectedToNet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetOrderUseCaseImpl
@Inject constructor(
    private val repository: OrderRepository
) {

    suspend operator fun invoke(
        context: Context,
        nameBook: String
    ): Flow<DataState<BaseResponse<OrderResponse>>> = flow {
        emit(DataState.Loading("Cargando ordenes..."))
        try {
            if (isConnectedToNet(context)) {
                val baseResponse = repository.getExternalOrder(nameBook = nameBook)
                if (baseResponse.success == "true") {
                    var order: Order
                    baseResponse.payload?.let { baseResponse ->
                        order = Order(
                            book = nameBook,
                        )
                        repository.cleanData(bookName = nameBook)
                        repository.saveOrder(order, baseResponse)
                    }
                }
            }
            val order =  repository.getLocalOrder(nameBook = nameBook)
            val response: OrderResponse
            order.let {
                response = OrderResponse(
                    asks = repository.getLocalAsks(nameBook = nameBook),
                    bids = repository.getLocalBids(nameBook = nameBook)
                )
            }
            emit(DataState.Success(
                BaseResponse(
                    success = "",
                    payload = response
                    )
                )
            )
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}