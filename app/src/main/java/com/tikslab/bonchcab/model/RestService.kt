package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.presenter.TablePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestService {
    var response: Table? = null
    fun getRaspWithWeek(num: Int) {
        NetworkService
            .raspApi
            .getRaspWithNum(num)
            .enqueue(object : Callback<Table> {
                override fun onResponse(call: Call<Table>, resp: Response<Table>) {
                    TablePresenter.updateTable( resp.body()!!)
                }

                override fun onFailure(call: Call<Table>, t: Throwable) {
                    TablePresenter.updateTable(
                        Table(
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