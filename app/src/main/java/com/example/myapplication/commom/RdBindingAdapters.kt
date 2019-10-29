package com.example.myapplication.commom

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.components.MusicTrackView
import com.example.myapplication.recyclerview.RowRecyclerView
import com.example.myapplication.recyclerview.base.BaseAdapterRD

@BindingAdapter("adapter")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: BaseAdapterRD<T>) {
    recyclerView.adapter = data
}


@BindingAdapter("data", "listener")
fun setDataListener(
    editText: EditText,
    data: RowRecyclerView,
    listener: MusicTrackView.OnClickListener
) {
    val musicTrackView = editText.parent as MusicTrackView
    musicTrackView.setData(data, listener)
}