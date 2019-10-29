package com.example.myapplication.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.myapplication.R
import com.example.myapplication.recyclerview.RowRecyclerView
import kotlinx.android.synthetic.main.rd_edittext_custom.view.*

class MusicTrackView(
    context: Context,
    attrs: AttributeSet? = null
) : CoordinatorLayout(context, attrs) {


    interface OnClickListener {
        fun onClick(valor: String)
    }


    init {

        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.rd_edittext_custom, this, false)

        addView(view)
    }

    fun setData(obj: RowRecyclerView, listener: OnClickListener) {

        edt_custom.setText(obj.nome)

        edt_custom.setOnClickListener { listener.onClick(obj.nome) }

    }

}