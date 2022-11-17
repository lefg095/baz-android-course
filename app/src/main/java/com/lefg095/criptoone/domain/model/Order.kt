package com.lefg095.criptoone.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

@Entity(tableName = "order_table")
data class Order(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var uid: Int = 0,

    @Expose
    @ColumnInfo
    var book: String
)