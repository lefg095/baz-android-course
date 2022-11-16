package com.lefg095.criptoone.ui.callbacks

import com.lefg095.criptoone.domain.model.Ticker

interface TickerCallBack {


    fun onLoading(msg: String)
    fun onError(error: String)
    fun onSucess(ticker: Ticker)
}
