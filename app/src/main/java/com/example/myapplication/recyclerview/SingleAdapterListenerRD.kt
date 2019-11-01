package com.example.myapplication.recyclerview

import android.util.SparseArray

class SingleAdapterListenerRD<T>(
    layoutId: Int,
    private val mLista: List<T>,
    private val extraBinding: SparseArray<Any>?,
    private var variableId: Int? = null
) :
    SingleLayoutAdapter<T>(layoutId) {

    override fun getObjForPosition(position: Int): T {
        return mLista[position]
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun extraBindings(): SparseArray<Any>? {
        return extraBinding
    }

    override fun variableIdObject(): Int {
        return variableId?.let { variableId } ?: super.variableIdObject()
    }

}