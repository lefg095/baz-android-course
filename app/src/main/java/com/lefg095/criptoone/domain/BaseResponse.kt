package com.lefg095.criptoone.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponse(
    @Expose
    @SerializedName("success")
    var success: String = "",
    @Expose
    @SerializedName("payload")
    var payload: List<Book> = listOf()
)

/*"success": true,
    "payload*/