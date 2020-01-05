package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.DayOfWeek
import com.tikslab.bonchcab.model.pojo.Lesson
import com.tikslab.bonchcab.model.pojo.Table
import com.tikslab.bonchcab.view.home.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestService {
    var response: Table? = null
    fun getRaspWithWeek(num: Int, obj: HomeViewModel) {
        NetworkService
            .raspApi
            .getRaspWithNum(num)
            .enqueue(object : Callback<Table> {
                override fun onResponse(call: Call<Table>, resp: Response<Table>) {
                    obj.updateTable(resp.body()!!)
                }

                override fun onFailure(call: Call<Table>, t: Throwable) {
                    obj.updateTable(
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