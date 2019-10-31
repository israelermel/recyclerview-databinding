package com.example.myapplication.recyclerview

import com.example.myapplication.recyclerview.base.ComponentType

class ListaViewModel {

    var editTextAdapter: MultiLayoutAdapterRD<RowRecyclerView>

    init {

        val lista = mutableListOf<RowRecyclerView>()
        lista.add(RowRecyclerView("israel1", ComponentType.EditText))
        lista.add(RowRecyclerView("israel2", ComponentType.EditText))
        lista.add(RowRecyclerView("israel3", ComponentType.EditText))
        lista.add(RowRecyclerView("israel4", ComponentType.TextView))
        lista.add(RowRecyclerView("israel5", ComponentType.TextView))
        lista.add(RowRecyclerView("israel6", ComponentType.TextView))
        lista.add(RowRecyclerView("israel7", ComponentType.TextView))

        editTextAdapter = MultiLayoutAdapterRD(lista)
    }

}