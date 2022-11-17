package com.lefg095.criptoone.data.presenter

import android.content.Context
import android.util.Log
import com.lefg095.criptoone.data.TickerRepository
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.ui.callbacks.TickerCallBack
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class TickerPresenter(var view: TickerCallBack, val context: Context, private val tickerRepository: TickerRepository) {

    fun getTicker(bookName: String) {
        val subscriber: Subscriber<BaseResponse<Ticker>> =
            object  : Subscriber<BaseResponse<Ticker>>(){
                override fun onCompleted() {
                    Log.i("getTicker_", "onCompleted")
                }

                override fun onError(e: Throwable?) {
                    Log.e("getTicker_", "onError_$e")
                    view.onError()
                }

                override fun onNext(t: BaseResponse<Ticker>?) {
                    view.onLoading("Cargando ticker...")
                    Log.i("getTicker_", "next")
                    t?.payload?.let { view.onSucess(it) }
                }

            }

        tickerRepository.getExternalTickerObs(nameBook = bookName)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError{ Log.e("getTicker_", "doOnError") }
            .subscribe(subscriber)
    }

}