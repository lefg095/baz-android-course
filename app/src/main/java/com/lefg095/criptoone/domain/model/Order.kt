package com.lefg095.criptoone.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.lefg095.criptoone.domain.model.Ask
import com.lefg095.criptoone.domain.model.Bid

@Entity(tableName = "order_table")
data class Order(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var uid: Int = 0,

    @Expose
    @ColumnInfo
    var book: String
)