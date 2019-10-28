package com.example.myapplication.recyclerview

abstract class SingleLayoutAdapter<T>(private val layoutId: Int) : BaseAdapterRD<T>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}