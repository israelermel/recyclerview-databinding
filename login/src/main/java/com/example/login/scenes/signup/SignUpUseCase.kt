package com.example.login.scenes.signup

interface SignUpUseCase : UseCase<SignUpUseCase.Result> {
    sealed class Result {
        object SignUpSuccess : Result()
        data class OnSignUpError(val message: String) : Result()
    }
}