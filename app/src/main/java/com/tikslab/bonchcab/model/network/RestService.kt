package com.tikslab.bonchcab.model.network

import com.tikslab.bonchcab.model.Util
import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.presenter.AuthPresenter
import com.tikslab.bonchcab.presenter.TablePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestService {
    fun getRaspWithWeek(num: Int, email: String, pass: String) {
        NetworkService
            .TABLE_API
            .getRaspWithNum(num, email, pass)
            .enqueue(object : Callback<WeekTable> {
                override fun onResponse(call: Call<WeekTable>, resp: Response<WeekTable>) {
                    TablePresenter.updateTable(
                        resp.body() ?: Util.getErrorTable("Занятий не найдено")
                    )
                }

                override fun onFailure(call: Call<WeekTable>, t: Throwable) {
                    TablePresenter.updateTable(
                        Util.getErrorTable(
                            t.localizedMessage!!
                        )
                    )
                }
            })
    }

    fun auth(email: String, pass: String) {
        NetworkService
            .TABLE_API
            .logIn(email, pass)
            .enqueue(object : Callback<Void> {
                override fun onFailure(call: Call<Void>, t: Throwable) {
                    AuthPresenter.authError()
                }

                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    if (response.code() == 200) AuthPresenter.authSuccess()
                    else AuthPresenter.authError()
                }

            })
    }
}