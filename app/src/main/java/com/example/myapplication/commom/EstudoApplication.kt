package com.example.myapplication.commom

import android.app.Application

class EstudoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ApplicationModulesLoader().loadModules(this)
    }


}