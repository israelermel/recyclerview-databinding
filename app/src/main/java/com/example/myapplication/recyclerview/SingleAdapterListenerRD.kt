package com.example.myapplication.recyclerview

class SingleAdapterListenerRD<T>(
    layoutId: Int,
    private val mLista: List<T>,
    private val listener: OnItemClick<T>?
) :
    SingleLayoutAdapter<T>(layoutId) {

    override fun onSelectedItem(item: T): OnItemClick<T>? {
        listener?.let {
            return listener.onSelectedItem(item)
        }
        return null
    }

    override fun getObjForPosition(position: Int): T {
        return mLista[position]
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

}