package com.tikslab.bonchcab.model

import com.tikslab.bonchcab.model.pojo.WeekTable
import com.tikslab.bonchcab.presenter.AuthPresenter
import com.tikslab.bonchcab.presenter.TablePresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object RestService {
    var response: WeekTable? = null
    fun getRaspWithWeek(num: Int, email: String, pass: String) {
        NetworkService
            .raspApi
            .getRaspWithNum(num, email, pass)
            .enqueue(object : Callback<WeekTable> {
                override fun onResponse(call: Call<WeekTable>, resp: Response<WeekTable>) {
                    TablePresenter.updateTable(resp.body()!!)
                }

                override fun onFailure(call: Call<WeekTable>, t: Throwable) {
                    TablePresenter.updateTable(Util.getErrorTable(t.localizedMessage!!))
                }
            })
        //return response!!
    }

    fun auth(email: String, pass: String) {
        NetworkService
            .raspApi
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