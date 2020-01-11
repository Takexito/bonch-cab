package com.tikslab.bonchcab.presenter

import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.view.TableAdapter
import com.tikslab.bonchcab.view.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_home.*

object TablePresenter {
    lateinit var view: HomeFragment
    var currWeek = 17
    var weekTable = WeekTable(
        mapOf(
            Pair(
                DayOfWeek.MONDAY,
                arrayListOf(Lesson("Load", "", "", "", ""))
            )
        )
    )

    fun init(view: HomeFragment){
        this.view = view
    }

    private fun loadNextWeek() {
        currWeek++
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek)
    }

    private fun loadCurrWeek(){
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek)
    }

    private fun loadPrevWeek() {
        currWeek--
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek)
    }

    fun updateTable(table: WeekTable) {
        weekTable = table
        view.updateWeek()
        view.hideProgressBar()
    }

    fun onPrevWeek() {
        loadPrevWeek()
        view.updateWeek()

    }

    fun onNextWeek() {
        loadNextWeek()
        view.updateWeek()

    }

    fun onStart(){
        loadCurrWeek()
        view.updateWeek()

    }


}