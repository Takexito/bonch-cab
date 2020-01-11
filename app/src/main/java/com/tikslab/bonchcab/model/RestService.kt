package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.presenter.TablePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestService {
    var response: WeekTable? = null
    fun getRaspWithWeek(num: Int) {
        NetworkService
            .raspApi
            .getRaspWithNum(num)
            .enqueue(object : Callback<WeekTable> {
                override fun onResponse(call: Call<WeekTable>, resp: Response<WeekTable>) {
                    TablePresenter.updateTable( resp.body()!!)
                }

                override fun onFailure(call: Call<WeekTable>, t: Throwable) {
                    TablePresenter.updateTable(
                        WeekTable(
                            mapOf(
                                Pair(
                                    DayOfWeek.MONDAY,
                                    arrayListOf(Lesson(t.localizedMessage!!, "", "", "", ""))
                                )
                            )
                        )
                    )
                }
            })
        //return response!!
    }
}