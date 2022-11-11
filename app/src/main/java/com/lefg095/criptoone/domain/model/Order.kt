package com.lefg095.criptoone.domain


import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "order")
data class Order(

    @Expose
    @ColumnInfo
    var asks: List<Ask>,

    @Expose
    @ColumnInfo
    var bids: List<Bid>,

    @Expose
    @ColumnInfo
    var sequence: String,

    @Expose
    @SerializedName("updated_at")
    var updatedAt: String
)