package com.tikslab.bonchcab.presenter

import android.util.Log
import com.tikslab.bonchcab.TableAdapter
import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table

object TablePresenter {
    lateinit var adapter: TableAdapter
    var tables = arrayListOf<Table>()
    var isNextLoading = false
    var isPrevLoading = false
    var isFirstLoading = true
    var prevWeek = 17
    var nextWeek = prevWeek - 1

    fun loadNextWeek(){
        nextWeek++
        Log.d("Recycler onScrolled", "Load next. Week")
        isNextLoading = true
        RestService.getRaspWithWeek(nextWeek)
    }

    fun loadPrevWeek(){
        prevWeek--
        Log.d("Recycler onScrolled", "Load prev. Week")
        isPrevLoading = true
        RestService.getRaspWithWeek(prevWeek)
    }

    fun updateTable(table: Table) {
        if(isPrevLoading || isFirstLoading){
            isFirstLoading = false
            isPrevLoading = false
            tables.add(0, table)
        }
        else if(isNextLoading) {
            isNextLoading = false
            tables.add(table)
        }
        adapter.notifyDataSetChanged()
    }

    fun scrollLoad(isNext: Boolean) {
        if (isNext && !isNextLoading) {
            loadNextWeek()
        }
        else if (!isNext && !isPrevLoading){
            loadPrevWeek()
        }
    }

    fun getLessons(index: Int): ArrayList<Lesson>{
        val list = arrayListOf<Lesson>()
        tables[index].lessons.forEach{
            list.addAll(it.value)
        }
        return list
    }

    fun getLessonsSize(): Int{
        var size = 0
        tables.forEach {
            size += it.lessons.size
        }
        return size
    }
}