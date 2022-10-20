package com.lefg095.criptoone.domain

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
/*
https://api.bitso.com/v3/available_books/
 */
@Parcelize
class Book(
    @Expose
    @SerializedName("book")
    var book: String = "",
    @Expose
    @SerializedName("minimum_amount")
    var minimum_amount: String = "",
    @Expose
    @SerializedName("maximum_amount")
    var maximum_amount: String = "",
    @Expose
    @SerializedName("minimum_price")
    var minimum_price: String = "",
    @Expose
    @SerializedName("maximum_price")
    var maximum_price: String = "",
    @Expose
    @SerializedName("minimum_value")
    var minimum_value: String = "",
    @Expose
    @SerializedName("maximum_value")
    var maximum_value: String = ""
): Parcelable

/*
https://api.bitso.com/v3/ticker/

{
    "success": true,
    "payload": {
        "book": "btc_mxn",
        "volume": "22.31349615",
        "high": "5750.00",
        "last": "5633.98",
        "low": "5450.00",
        "vwap": "5393.45",
        "ask": "5632.24",
        "bid": "5520.01",
        "created_at": "2016-04-08T17:52:31.000+00:00"
    }
}

https://api.bitso.com/v3/order_book/

{
    "success": true,
    "payload": {
        "asks": [{
            "book": "btc_mxn",
            "price": "5632.24",
            "amount": "1.34491802"
        },{
            "book": "btc_mxn",
            "price": "5633.44",
            "amount": "0.4259"
        },{
            "book": "btc_mxn",
            "price": "5642.14",
            "amount": "1.21642"
        }],
        "bids": [{
            "book": "btc_mxn",
            "price": "6123.55",
            "amount": "1.12560000"
        },{
            "book": "btc_mxn",
            "price": "6121.55",
            "amount": "2.23976"
        }],
        "updated_at": "2016-04-08T17:52:31.000+00:00",
        "sequence": "27214"
    }
}
 */