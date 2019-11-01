package com.example.myapplication.recyclerview.base

import android.util.SparseArray

interface BindExtraItem {
    fun extraBindings(): SparseArray<Any>?
}
