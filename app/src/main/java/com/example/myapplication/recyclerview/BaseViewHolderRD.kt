package com.example.myapplication.recyclerview

import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolderRD<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val VAR_NONE = 0


    fun bind(obj: T, variableId: Int) {
        binding.setVariable(variableId, obj)
        binding.executePendingBindings()
    }

    fun bind(obj: T, extraBindings: SparseArray<Any>, variableId: Int) {
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

        bind(obj, variableId)
    }
}