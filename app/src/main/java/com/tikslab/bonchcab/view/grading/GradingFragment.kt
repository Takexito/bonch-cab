package com.tikslab.bonchcab.view.grading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tikslab.bonchcab.R

class GradingFragment : Fragment() {

    private lateinit var gradingViewModel: GradingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        gradingViewModel =
            ViewModelProviders.of(this).get(GradingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_grading, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        gradingViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}