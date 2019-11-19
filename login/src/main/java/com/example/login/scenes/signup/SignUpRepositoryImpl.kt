package com.example.login.scenes.signup

import android.util.Log
import com.example.login.scenes.signup.data.SignUpApi
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SignUpRepositoryImpl constructor(private val signUpApi: SignUpApi) {
    fun teste(): Single<Int>? {
        return Observable.fromCallable {
            Log.d("teste", "teste")
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .singleOrError()
    }

    /*

    Model vindo do Rest , criar mapper para ele,
    usar AndroidSchedulers e Scheduler nos metodos aqui

    validar e lancar um exception personalizada aqui

     */

}