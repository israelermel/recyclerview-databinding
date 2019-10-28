package com.example.myapplication.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("adapter")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: BaseAdapterRD<T>) {
    recyclerView.adapter = data
}