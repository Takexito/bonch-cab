package com.tikslab.bonchcab.presenter

import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.view.TableAdapter

object TablePresenter {
    lateinit var adapter: TableAdapter
    var currWeek = 17
    var weekTable = WeekTable(
        mapOf(
            Pair(
                DayOfWeek.MONDAY,
                arrayListOf(Lesson("Load", "", "", "", ""))
            )
        )
    )

    fun loadNextWeek() {
        currWeek++
        RestService.getRaspWithWeek(currWeek)
    }

    fun loadPrevWeek() {
        currWeek--
        RestService.getRaspWithWeek(currWeek)
    }

    fun updateTable(table: WeekTable) {
        weekTable = table
        adapter.notifyDataSetChanged()
    }

}