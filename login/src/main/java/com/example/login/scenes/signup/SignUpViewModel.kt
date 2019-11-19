package com.example.login.scenes.signup

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel constructor(
    private val useCase: SignUpUseCaseImpl
) : ViewModel() {

    val formMediator = MediatorLiveData<Boolean>()

    val sucesso = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    private fun configFieldsMediator() {
        formMediator.addSource(useCase.getLiveData()) {
            when (it) {
                is SignUpUseCase.Result.SignUpSuccess -> {
                    sucesso.postValue(true)
                }
                is SignUpUseCase.Result.OnSignUpError -> {
                    error.postValue(it.message)
                }
            }
        }
    }
}