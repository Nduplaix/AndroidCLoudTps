package com.example.minitp1.mmo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/** Object use for Ui */
data class MmoUi(
    val short_description: String,
    val thumbnail: String
)

/** Object use for room */
@Entity(tableName = "chuck_norris_quote")
data class MmoRoom(
    @ColumnInfo(name = "quote_text")
    val short_description: String,


    @ColumnInfo(name = "quote_icon_url")
    val thumbnail: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class MmoRetrofit(
    @Expose
    @SerializedName("short_description")
    val short_description: String,


    @Expose
    @SerializedName("thumbnail")
    val thumbnail: String
)
