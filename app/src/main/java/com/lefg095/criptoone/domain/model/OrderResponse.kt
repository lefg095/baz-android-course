package com.lefg095.criptoone.domain.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderResponse(
    @Expose
    var asks: List<Ask>,

    @Expose
    var bids: List<Bid>,

    @Expose
    var sequence: String,

    @Expose
    @SerializedName("updated_at")
    var updatedAt: String
)