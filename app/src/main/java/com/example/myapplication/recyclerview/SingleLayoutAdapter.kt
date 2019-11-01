package com.example.myapplication.recyclerview

import com.example.myapplication.recyclerview.base.BaseAdapterRD

abstract class SingleLayoutAdapter<T>(private val layoutId: Int) : BaseAdapterRD<T>() {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

}