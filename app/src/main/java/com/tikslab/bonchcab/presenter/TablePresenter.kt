package com.tikslab.bonchcab.presenter

import android.util.Log
import com.tikslab.bonchcab.TableAdapter
import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table

object TablePresenter {
    lateinit var adapter: TableAdapter
    var tables = Table(
        mapOf(
            Pair(
                DayOfWeek.MONDAY,
                arrayListOf(Lesson("Load", "", "", "", ""))
            )
        )
    )

    var currWeek = 17

    fun loadNextWeek(){
        currWeek++
        RestService.getRaspWithWeek(currWeek)
    }

    fun loadPrevWeek(){
        currWeek--
        RestService.getRaspWithWeek(currWeek)
    }

    fun updateTable(table: Table) {
        tables = table
        adapter.notifyDataSetChanged()
    }

}