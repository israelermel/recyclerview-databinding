package com.example.myapplication.recyclerview

import com.example.myapplication.recyclerview.base.OnItemClickRownRecyclerView

class SingleItemAdapterRD<T>(
    layoutId: Int,
    private val mLista: List<T>,
    private val listener: OnItemClickRownRecyclerView
) :
    SingleLayoutAdapter<T>(layoutId) {

    override fun getObjForPosition(position: Int): T {
        return mLista[position]
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun listener(): OnItemClickRownRecyclerView? {
        return listener
    }
}