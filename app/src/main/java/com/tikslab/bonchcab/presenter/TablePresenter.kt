package com.tikslab.bonchcab.presenter

import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.Util
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.view.home.HomeFragment

object TablePresenter {
    lateinit var view: HomeFragment
    var currWeek = Util.getWeek()
    var weekTable = Util.getErrorTable("Load")

    fun init(view: HomeFragment) {
        this.view = view
    }

    private fun loadNextWeek() {
        currWeek++
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek, AuthPresenter.email, AuthPresenter.pass)
    }

    private fun loadCurrWeek() {
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek, AuthPresenter.email, AuthPresenter.pass)
    }

    private fun loadPrevWeek() {
        currWeek--
        view.showProgressBar()
        RestService.getRaspWithWeek(currWeek, AuthPresenter.email, AuthPresenter.pass)
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

    fun onStart() {
        loadCurrWeek()
        view.updateWeek()

    }


}