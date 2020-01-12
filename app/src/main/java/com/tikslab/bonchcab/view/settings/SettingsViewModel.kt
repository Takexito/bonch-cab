package com.tikslab.bonchcab.view.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Настройки. В разработке."
    }
    val text: LiveData<String> = _text
}