package com.lefg095.criptoone.domain.usecase

import android.content.Context
import com.lefg095.criptoone.data.TickerRepository
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.stateevent.DataState
import com.lefg095.criptoone.util.isConnectedToNet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetTickerUseCaseImpl
@Inject
constructor(
    private val repository: TickerRepository
){

    suspend operator fun invoke(
        context: Context,
        bookName: String
    ): Flow<DataState<BaseResponse<Ticker>>> = flow {
        emit(DataState.Loading("Cargando detalle..."))
        try {
            if (isConnectedToNet(context)) {
                val response = repository.getExternalTicker(bookName)
                if (response.success == "true") {
                    val ticker: Ticker? = response.payload
                    ticker?.let {
                        repository.cleanTicker(it.book)
                        repository.saveTicker(it)
                    }
                }
            }
            emit(
                DataState.Success(
                    BaseResponse(
                        success = "",
                        payload = repository.getLocalticker(bookName)
                    )
                )
            )
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }

}