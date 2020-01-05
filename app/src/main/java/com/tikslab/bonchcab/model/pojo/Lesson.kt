package com.tikslab.bonchcab.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Lesson(
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("location")
    @Expose
    val location: String,
    @SerializedName("teacherName")
    @Expose
    val teacherName: String,
    @SerializedName("num")
    @Expose
    val num: String
) {

    override fun toString(): String {
        return "$num  $name"
    }
}