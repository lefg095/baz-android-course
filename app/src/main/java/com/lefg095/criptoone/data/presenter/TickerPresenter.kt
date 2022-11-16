package com.lefg095.criptoone.data.presenter

import android.content.Context
import android.util.Log
import com.lefg095.criptoone.data.TickerRepository
import com.lefg095.criptoone.di.ApiClient
import com.lefg095.criptoone.domain.dao.TickerDao
import com.lefg095.criptoone.domain.model.Ticker
import com.lefg095.criptoone.domain.response.BaseResponse
import com.lefg095.criptoone.domain.usecase.GetTickerUseCaseImpl
import com.lefg095.criptoone.ui.callbacks.TickerCallBack
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.subscribeOn
import retrofit2.Retrofit
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class TickerPresenter
@Inject constructor(
    val mCallBack: TickerCallBack,
    val useCaseImpl: GetTickerUseCaseImpl
    ) {


    fun getTicker(context: Context, bookName: String) {

      /*  val observable = Observable.create<BaseResponse<Ticker>> { emitter ->
            emitter.onNext(useCaseImpl.getTicker(
                context = context,
                bookName = bookName))
            emitter.onCompleted()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        observable.subscribe({
            if (it.success == "") {
                if (it.payload != null) {
                    mCallBack.onSucess(it.payload!!)
                }else {
                    mCallBack.onError("Sin datos")
                }
            }else {
                mCallBack.onError("Fallo respuesta")
            }
        },{
            mCallBack.onError(it.toString())
        },{

        })*/

        /*Observable.fromCallable{
          useCaseImpl.getTicker(
              context = context,
              bookName = bookName)
        }.subscribeOn(Schedulers.newThread())
            .doOnSubscribe { mCallBack.onLoading("") }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ (success, payload) ->
                if (success == "") {
                    if (payload != null) {
                        mCallBack.onSucess(payload)
                    }else {
                        mCallBack.onError("Sin datos")
                    }
                }else {
                    mCallBack.onError("Fallo respuesta")
                }
            }) { throwable: Throwable ->
                mCallBack.onError(throwable.toString())
            }*/
    }

}