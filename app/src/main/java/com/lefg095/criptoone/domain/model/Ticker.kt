package com.lefg095.criptoone.domain


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ticker")
data class Ticker(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @Expose
    @ColumnInfo
    var ask: String = "",

    @Expose
    @ColumnInfo
    var bid: String,

    @Expose
    @ColumnInfo
    var book: String,

    @ColumnInfo(name = "created_at")
    @SerializedName("created_at")
    var createdAt: String = "",

    @Expose
    @ColumnInfo
    var high: String,

    @Expose
    @ColumnInfo
    var last: String,

    @Expose
    @ColumnInfo
    var low: String,

    @Expose
    @ColumnInfo
    var volume: String,

    @Expose
    @ColumnInfo
    var vwap: String
): Parcelable