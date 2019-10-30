package com.example.myapplication.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BR

class BaseViewHolderRD<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: T) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }

    fun bind(obj: T, listener: OnItemClick<T>) {
        binding.setVariable(BR.obj, obj)
        binding.setVariable(BR.listener, listener)
        binding.executePendingBindings()
    }
}