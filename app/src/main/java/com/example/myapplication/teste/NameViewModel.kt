package com.example.myapplication.teste

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.florent37.application.provider.ActivityProvider

class NameViewModel : ViewModel() {

    init {
        teste()
    }

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val edtName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun teste() {
        ActivityProvider.currentActivity
    }


}