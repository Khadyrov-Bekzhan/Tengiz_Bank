package com.example.kaspi.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {
    private val _messages = MutableLiveData<List<Message>>()
    val messages: LiveData<List<Message>> = _messages

    init {
        loadMessages()
    }

    private fun loadMessages() {
        // Использование демо-данных из компаньон объекта
        _messages.value = Message.createDemoMessages()
    }
}