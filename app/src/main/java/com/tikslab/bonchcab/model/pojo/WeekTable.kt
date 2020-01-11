package com.tikslab.bonchcab.model.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class WeekTable(
    @SerializedName("days")
    @Expose
    val days: Map<DayOfWeek, ArrayList<Lesson>>
)