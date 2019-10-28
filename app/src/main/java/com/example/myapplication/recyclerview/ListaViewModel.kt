package com.example.myapplication.recyclerview

import com.example.myapplication.R

class ListaViewModel {

    var testeAdapter: TesteAdapterRD<ObjTeste>

    init {

        val lista = mutableListOf<ObjTeste>()
        lista.add(ObjTeste("israel1"))
        lista.add(ObjTeste("israel2"))
        lista.add(ObjTeste("israel3"))
        lista.add(ObjTeste("israel4"))
        lista.add(ObjTeste("israel5"))
        lista.add(ObjTeste("israel6"))

        testeAdapter = TesteAdapterRD(R.layout.edittext_layout, lista)

    }
}