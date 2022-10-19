package com.lefg095.criptoone.domain


data class BaseResponse<T>(
    var success: String = "",
    var payload: List<T> = listOf()
)

/*"success": true,
    "payload*/