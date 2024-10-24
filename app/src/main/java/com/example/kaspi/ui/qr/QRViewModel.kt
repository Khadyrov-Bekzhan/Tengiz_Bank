package com.example.kaspi.ui.qr

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QRViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Kaspi QR Fragment"
    }
    val text: LiveData<String> = _text
}