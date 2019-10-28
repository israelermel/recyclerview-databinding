package com.example.myapplication.commom

import org.koin.dsl.module.Module

abstract class ModuleDiManager {
    fun extractModules(modulesSet: List<MutableList<Module>>): MutableList<Module> {
        val moduleList = mutableListOf<Module>()

        for (set in modulesSet) {
            for (module in set) {
                moduleList.add(module)
            }
        }
        return moduleList
    }

    abstract fun getModules(): MutableList<Module>
}