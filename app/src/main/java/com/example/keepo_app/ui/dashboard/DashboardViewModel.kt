package com.example.keepo_app.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "자세 측정을 시작하려면 START를 누르세요"
    }
    val text: LiveData<String> = _text
}