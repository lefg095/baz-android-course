package com.lefg095.criptoone.domain.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose


@Entity(tableName = "ask_table")
data class Ask(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var uid: Int = 0,

    @Expose
    @ColumnInfo
    var amount: String,

    @Expose
    @ColumnInfo
    var book: String,

    @Expose
    @ColumnInfo
    var price: String
)