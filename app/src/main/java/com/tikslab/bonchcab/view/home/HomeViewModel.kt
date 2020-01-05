package com.tikslab.bonchcab.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.presenter.TablePresenter

class HomeViewModel : ViewModel() {

    private var _table = MutableLiveData<Table>()
    val text: LiveData<Table> = _table

    fun updateTable(data: Table) {
        //_table.value = presenter.getAdapterDataWithWeek(numOfWeek)
        _table.value = data
    }

    fun prevWeek() {
        TablePresenter.loadPrevWeek()
    }

    fun nextWeek() {
        TablePresenter.loadNextWeek()
    }

}