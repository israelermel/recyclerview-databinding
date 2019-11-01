package com.example.myapplication.recyclerview

import android.util.SparseArray
import com.example.myapplication.recyclerview.base.BaseAdapterRD
import com.example.myapplication.recyclerview.base.ComponentTypeImpl

class MultiLayoutAdapterRD<T>(private val lista: MutableList<T>) : BaseAdapterRD<T>() {

    override fun extraBindings(): SparseArray<Any>? {
        return null
    }

    var componentTypeImpl: ComponentTypeImpl = ComponentTypeImpl()

    override fun getObjForPosition(position: Int): T {
        return lista[position]
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun getLayoutIdForPosition(position: Int): Int {

        val row = getObjForPosition(position) as RowRecyclerView

        return componentTypeImpl.component(row.componentType)
    }

}