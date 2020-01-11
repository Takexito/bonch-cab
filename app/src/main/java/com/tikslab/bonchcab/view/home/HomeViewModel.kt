package com.tikslab.bonchcab.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.presenter.TablePresenter

class HomeViewModel : ViewModel() {

    private var _table = MutableLiveData<WeekTable>()
    val text: LiveData<WeekTable> = _table

    fun updateTable(data: WeekTable) {
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