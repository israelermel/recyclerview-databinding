package com.example.myapplication.recyclerview.base

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: BaseAdapterRD<T>) {
    recyclerView.adapter = data
}