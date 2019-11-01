package com.example.myapplication.recyclerview

import android.util.SparseArray

class SingleAdapterListenerRD<T>(
    layoutId: Int,
    private val mLista: List<T>,
    private val extraBinding: SparseArray<Any>?
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

}