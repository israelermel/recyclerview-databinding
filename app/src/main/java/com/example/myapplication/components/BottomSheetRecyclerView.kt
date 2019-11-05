package com.example.myapplication.components

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerview.SingleAdapterListenerRD
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetRecyclerView<T> : BottomSheetDialog, View.OnClickListener {

    private var btnClose: ImageButton? = null
    private var titleView: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var extraBindings: SparseArray<Any>? = null
    private var layoutIdBottom: Int? = null
    private var variableLayout: Int? = null

    private constructor(
        context: Context,
        title: String? = null,
        layoutId: Int? = null,
        listItem: List<T>? = null,
        extraBindings: SparseArray<Any>? = null,
        variableLayout: Int? = null
    ) : super(
        context,
        R.style.BottomSheetDialogTheme
    ) {
        addLayoutId(layoutId)

        addVariableLayout(variableLayout)

        setDialogView()

        addTitle(title)
        addExtraBind(extraBindings)
        setRecyclerViewList(listItem)
    }

    private fun addTitle(title: String?) {
        titleView!!.text = title
    }

    constructor(context: Context) : super(context, R.style.BottomSheetDialogTheme) {
        setDialogView()
    }

    private fun setDialogView() {
        val bottomSheetView = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
        setContentView(bottomSheetView)

        btnClose = findViewById(R.id.btn_close_bottom_sheet_rd)
        titleView = findViewById(R.id.txt_title_bottom_sheet)
        recyclerView = findViewById(R.id.rcv_bottom_sheet_custom)

        btnClose!!.setOnClickListener(this)
    }

    private fun addVariableLayout(variableLayout: Int?) {
        this.variableLayout = variableLayout
    }

    private fun addLayoutId(layoutId: Int? = null) {
        if (layoutId == null) {
            layoutIdBottom = R.layout.item_textview_layout
        } else {
            this.layoutIdBottom = layoutId
        }
    }

    private fun addExtraBind(extraBindings: SparseArray<Any>? = null) {
        extraBindings?.let {
            this.extraBindings = extraBindings
        }
    }

    private fun setRecyclerViewList(list: List<T>? = null) {
        list?.let {
            val singleAdapterRD =
                SingleAdapterListenerRD(layoutIdBottom!!, list, extraBindings, variableLayout)

            recyclerView!!.adapter = singleAdapterRD
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }

    data class Builder<T>(
        private var context: Context,
        private var title: String? = null,
        private var layoutId: Int? = null,
        private var list: List<T>? = null,
        private var extraBindings: SparseArray<Any> = SparseArray(),
        private var variableLayout: Int? = null
    ) {
        fun addTitle(title: String) = apply { this.title = title }

        fun addLayoutId(layoutId: Int) = apply { this.layoutId = layoutId }

        fun addList(list: List<T>, variableLayout: Int? = null) = apply {
            this.list = list
            variableLayout?.let { this.variableLayout = it }
        }

        fun addExtraBinding(variableId: Int, value: Any) = apply {
            extraBindings.put(variableId, value)
        }

        fun build() =
            BottomSheetRecyclerView(context, title, layoutId, list, extraBindings, variableLayout)

    }
}