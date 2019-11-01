package com.example.myapplication.recyclerview

import com.example.myapplication.recyclerview.base.BaseAdapterRD

class MultiLayoutAdapterRD<T>(private val lista: MutableList<T>) : BaseAdapterRD<T>() {

    override fun getObjForPosition(position: Int): T {
        return lista[position]
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun getLayoutIdForPosition(position: Int): Int {

        val row = getObjForPosition(position) as RowRecyclerView

        return row.componentType.layoutId
    }

}