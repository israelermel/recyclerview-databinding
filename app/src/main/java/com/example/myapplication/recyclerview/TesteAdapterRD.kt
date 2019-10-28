package com.example.myapplication.recyclerview

class TesteAdapterRD<T>(layoutId: Int, private val mLista: List<T>) :
    SingleLayoutAdapter<T>(layoutId) {

    override fun getObjForPosition(position: Int): T {
        return mLista[position]
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

}
