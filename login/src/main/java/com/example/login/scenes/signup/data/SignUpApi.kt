package com.example.login.scenes.signup.data

import io.reactivex.Single


class SignUpApi {
    fun criaUsuario(): Single<Usuario> {
        return Single.fromCallable()
    }
}