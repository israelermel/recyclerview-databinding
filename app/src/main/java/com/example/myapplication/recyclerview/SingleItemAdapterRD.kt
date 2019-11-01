package com.example.myapplication.recyclerview

import android.util.SparseArray

class SingleItemAdapterRD<T>(
    layoutId: Int,
    private val mLista: List<T>
) :
    SingleLayoutAdapter<T>(layoutId) {

    override fun extraBindings(): SparseArray<Any>? {
        return null
    }

    override fun getObjForPosition(position: Int): T {
        return mLista[position]
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

}