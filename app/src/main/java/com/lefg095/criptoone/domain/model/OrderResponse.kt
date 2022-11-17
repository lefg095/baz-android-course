package com.lefg095.criptoone.domain.model

import com.google.gson.annotations.Expose

data class OrderResponse(
    @Expose
    var asks: List<Ask>,

    @Expose
    var bids: List<Bid>
)