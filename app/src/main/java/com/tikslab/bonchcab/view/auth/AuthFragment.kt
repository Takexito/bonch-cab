package com.tikslab.bonchcab.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.presenter.AuthPresenter
import kotlinx.android.synthetic.main.fragment_auth.*


class AuthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AuthPresenter.init(this)
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (AuthPresenter.isAutoAuth()) return

        hideProgress()
        loginButton.setOnClickListener {
            val email = emailEdit.text.toString()
            val pass = passEdit.text.toString()
            AuthPresenter.onAuthButton(email, pass)
        }
    }

    fun hideProgress() {
        loginProgress.visibility = View.GONE
        emailEdit.visibility = View.VISIBLE
        passEdit.visibility = View.VISIBLE
        loginButton.visibility = View.VISIBLE

    }

}
