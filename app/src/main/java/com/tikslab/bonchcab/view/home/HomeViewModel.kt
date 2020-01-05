package com.tikslab.bonchcab.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.presenter.RaspPresenter

class HomeViewModel : ViewModel() {

    private val presenter = RaspPresenter()
    private var numOfWeek = 17
    private var _table = MutableLiveData<Table>()
    val text: LiveData<Table> = _table

    fun updateTable(data: Table) {
        //_table.value = presenter.getAdapterDataWithWeek(numOfWeek)
        _table.value = data
    }

    fun prevWeek() {
        numOfWeek--
        getAdapterDataWithWeek()
    }

    fun nextWeek() {
        numOfWeek++
        getAdapterDataWithWeek()
    }

    fun getAdapterDataWithWeek() {
        RestService.getRaspWithWeek(numOfWeek, this)
    }
}