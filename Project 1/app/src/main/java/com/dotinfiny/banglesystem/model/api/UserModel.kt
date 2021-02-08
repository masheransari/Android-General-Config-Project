package com.dotinfiny.banglesystem.model.api

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class UserModel(

    @PrimaryKey
    @Expose
    @SerializedName("_id")
    val _id: String,

    @Expose
    @SerializedName("name")
    val name: String

)