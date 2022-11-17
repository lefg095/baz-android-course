package com.lefg095.criptoone.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "book_table")
data class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var uid: Int = 0,

    @Expose
    @ColumnInfo
    var book: String = "",

    @Expose
    @ColumnInfo
    var minimum_amount: String = "",

    @Expose
    @ColumnInfo
    var maximum_amount: String = "",

    @Expose
    @ColumnInfo
    var minimum_price: String = "",

    @Expose
    @ColumnInfo
    var maximum_price: String = "",

    @Expose
    @ColumnInfo
    var minimum_value: String = "",

    @Expose
    @ColumnInfo
    var maximum_value: String = ""
): Parcelable