package com.example.login.scenes.signup

import androidx.lifecycle.MutableLiveData

abstract class BaseUseCase<T>(
    private val liveData: MutableLiveData<T> = MutableLiveData()
) : UseCase<T> {

    override fun getLiveData(): MutableLiveData<T> = liveData

    override fun cleanUp() {

    }
}
