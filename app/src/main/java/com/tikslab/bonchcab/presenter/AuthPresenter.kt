package com.tikslab.bonchcab.presenter

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import com.tikslab.bonchcab.MainActivity
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.model.RestService
import com.tikslab.bonchcab.view.AuthFragment

object AuthPresenter {

    var email = ""
    var pass = ""
    lateinit var view: AuthFragment

    fun init(view: AuthFragment) {
        this.view = view
    }

    fun authError(): String {
        val error = ""
        view.hideProgress()
        Toast.makeText(view.context, "Bad email/pass", Toast.LENGTH_SHORT).show()
        return error
    }

    fun authSuccess() {
        saveAuthData(view.activity!!.getPreferences(Context.MODE_PRIVATE))
        (view.requireActivity() as MainActivity).navigateToHomeFragment()
    }

    fun onAuthButton(email: String, pass: String) {
        this.email = email
        this.pass = pass
        RestService.auth(email, pass)
    }

    fun isAutoAuth(): Boolean {
        val isSuccess = loadAuthData(view.activity!!.getPreferences(Context.MODE_PRIVATE))
        RestService.auth(email, pass)
        return isSuccess
    }

    private fun saveAuthData(preferences: SharedPreferences) {
        preferences.edit()
            .putString(
                R.string.email_key.toString(),
                email
            )
            .putString(
                R.string.pass_key.toString(),
                pass
            )
            .apply()
    }

    private fun loadAuthData(preferences: SharedPreferences): Boolean {
        if (!preferences.contains(R.string.email_key.toString())) return false
        if (!preferences.contains(R.string.pass_key.toString())) return false
        email = preferences.getString(R.string.email_key.toString(), "")!!
        pass = preferences.getString(R.string.pass_key.toString(), "")!!
        return true
    }
}