package com.example.myapplication.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapterRD<T> : RecyclerView.Adapter<BaseViewHolderRD<T>>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolderRD<T> {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolderRD<T>(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolderRD<T>, position: Int) {
        val obj = getObjForPosition(position)
        holder.bind(obj)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): T

    protected abstract fun getLayoutIdForPosition(position: Int): Int
}