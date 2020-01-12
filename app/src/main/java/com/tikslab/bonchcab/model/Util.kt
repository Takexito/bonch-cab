package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.WeekTable
import java.util.*

object Util {

    fun getWeek(): Int {
        val now = Calendar.getInstance()
        val week = now.get(Calendar.WEEK_OF_YEAR)
        return if (week >= 40) week-35
        else week+17

    }

    fun getErrorTable(message: String): WeekTable {
        return WeekTable(
            mapOf(
                Pair(
                    DayOfWeek.MONDAY,
                    arrayListOf(Lesson("Error: $message", "", "", "", ""))
                )
            )
        )
    }

    fun getNoLessons(): Lesson {
        return Lesson("Занятий нет", "", "", "", "")
    }

    fun getCurrDay(): DayOfWeek{
        val now = Calendar.getInstance()
        val day = if(now.get(Calendar.DAY_OF_WEEK) == 1) 6
        else now.get(Calendar.DAY_OF_WEEK) - 2
        return DayOfWeek.values()[day]
    }
}