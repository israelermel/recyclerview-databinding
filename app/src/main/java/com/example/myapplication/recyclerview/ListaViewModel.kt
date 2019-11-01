package com.example.myapplication.recyclerview

import com.example.myapplication.enumteste.ComponentLayoutEnum

class ListaViewModel {

    var editTextAdapter: MultiLayoutAdapterRD<RowRecyclerView>

    init {

        val lista = mutableListOf<RowRecyclerView>()
        lista.add(RowRecyclerView("israel1", ComponentLayoutEnum.EDIT_TEXT))
        lista.add(RowRecyclerView("israel2", ComponentLayoutEnum.EDIT_TEXT))
        lista.add(RowRecyclerView("israel3", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel4", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel5", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel6", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel7", ComponentLayoutEnum.TEXT_VIEW))

        editTextAdapter = MultiLayoutAdapterRD(lista)
    }

}