package com.example.myapplication.recyclerview.base

import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.BR
import com.example.myapplication.recyclerview.BaseViewHolderRD

abstract class BaseAdapterRD<T> : RecyclerView.Adapter<BaseViewHolderRD<T>>(), BindExtraItem {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolderRD<T> {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)

        return BaseViewHolderRD(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolderRD<T>, position: Int) {
        val obj = getObjForPosition(position)

        extraBindings()?.let {
            holder.bind(obj, it, variableIdObject())
        } ?: holder.bind(obj, variableIdObject())

    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): T

    protected abstract fun getLayoutIdForPosition(position: Int): Int

    override fun extraBindings(): SparseArray<Any>? {
        return null
    }

    override fun variableIdObject(): Int {
        return BR.obj
    }

}