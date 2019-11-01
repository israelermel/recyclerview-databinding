package com.example.myapplication.recyclerview

import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BR

class BaseViewHolderRD<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val VAR_NONE = 0

    fun bind(obj: T) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()
    }

//    fun bind(obj: T, listener: OnItemClick<T>) {
//        binding.setVariable(BR.obj, obj)
//        binding.setVariable(BR.listener, listener)
//        binding.executePendingBindings()
//    }

    fun bind(obj: T, extraBindings: SparseArray<Any>) {
        var i = 0
        val size = extraBindings.size()
        while (i < size) {
            val variableId = extraBindings.keyAt(i)
            val value = extraBindings.valueAt(i)
            if (variableId != VAR_NONE) {
                binding.setVariable(variableId, value)
            }
            i++
        }

        bind(obj)
    }
}