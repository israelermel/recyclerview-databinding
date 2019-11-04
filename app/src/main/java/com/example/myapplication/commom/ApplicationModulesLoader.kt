package com.example.myapplication.commom

import android.content.Context
import com.example.myapplication.commom.mapper.ComponentConverter
import com.example.myapplication.teste.NameViewModel
import org.koin.android.ext.koin.with
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext

class ApplicationModulesLoader {


    fun loadModules(context: Context) {
        StandAloneContext.loadKoinModules(getModules()) with context
    }


    private fun getModules(): MutableList<Module> {
        return extractModules(mapModules())
    }

    private fun extractModules(modulesSet: List<MutableList<Module>>): MutableList<Module> {
        val moduleList = mutableListOf<Module>()

        for (set in modulesSet) {
            for (module in set) {
                moduleList.add(module)
            }
        }

        return moduleList
    }

    private fun mapModules(): List<MutableList<Module>> {
        return listOf(
            getModules2()
        )
    }

    private val nameViewModel = module {
        viewModel { NameViewModel() }
    }


    fun getModules2(): MutableList<Module> {
        return arrayListOf(nameViewModel, componentConverter)
    }

    private val componentConverter = module {
        single {
            ComponentConverter(get(), get())
        }
    }



}