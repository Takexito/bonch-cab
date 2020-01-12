package com.tikslab.bonchcab.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tikslab.bonchcab.R
import com.tikslab.bonchcab.presenter.AuthPresenter
import kotlinx.android.synthetic.main.fragment_log_in.*


class AuthFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        AuthPresenter.init(this)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false)
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

    companion object {
        @JvmStatic
        fun newInstance() = AuthFragment()
    }
}
