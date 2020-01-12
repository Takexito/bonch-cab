package com.tikslab.bonchcab.view.grading

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GradingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Зачетка. В разработке."
    }
    val text: LiveData<String> = _text
}