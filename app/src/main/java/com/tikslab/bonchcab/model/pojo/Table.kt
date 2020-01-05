package com.tikslab.bonchcab.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Table(
    @SerializedName("days")
    @Expose
    val lessons: Map<DayOfWeek, ArrayList<Lesson>>
)