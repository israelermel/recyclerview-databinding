package com.example.login.scenes.signup

import androidx.lifecycle.MutableLiveData

interface UseCase<T> {
    fun getLiveData(): MutableLiveData<T>
    fun cleanUp()
}
