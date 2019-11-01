package com.example.myapplication.components

import android.content.Context
import android.util.SparseArray
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerview.OnItemClick
import com.example.myapplication.recyclerview.SingleAdapterListenerRD
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetRecyclerView<T> : BottomSheetDialog, View.OnClickListener {

    private var btnClose: ImageButton? = null
    private var titleView: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var extraBindings: SparseArray<Any>? = null
    private var layoutIdBottom: Int? = null
    private var variableId: Int? = null

    private lateinit var onItemClickBottomSheet: OnItemClick<T>

    private constructor(
        context: Context,
        title: String?,
        layoutId: Int?,
        list: List<T>?,
        extraBindings: SparseArray<Any>?,
        variableId: Int? = null
    ) : super(
        context,
        R.style.BottomSheetDialogTheme
    ) {
        layoutId?.let { addLayoutId(layoutId) } ?: addLayoutId(R.layout.item_textview_layout)
        variableId?.let { addVariableId(it) }
        setDialogView()

        title?.let { setTitle(it) }
        extraBindings?.let { addExtraBind(it) }
        list?.let { setRecyclerViewList(it) }
    }

    fun addVariableId(variableId: Int) {
        this.variableId = variableId
    }

    fun addLayoutId(layoutId: Int) {
        layoutIdBottom = layoutId
    }

    fun addExtraBind(extraBindings: SparseArray<Any>) {
        this.extraBindings = extraBindings
    }

    constructor(context: Context) : super(context, R.style.BottomSheetDialogTheme) {
        setDialogView()
    }

    constructor(context: Context, onItemClickBottomSheet: OnItemClick<T>) : super(
        context,
        R.style.BottomSheetDialogTheme
    ) {
        this.onItemClickBottomSheet = onItemClickBottomSheet
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


    fun setTitle(title: String) {
        titleView!!.text = title
    }

    fun setRecyclerViewList(list: List<T>) {
        val singleAdapterRD =
            SingleAdapterListenerRD(layoutIdBottom!!, list, extraBindings, variableId)

        recyclerView!!.adapter = singleAdapterRD
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
        private var variableId: Int? = null
    ) {
        fun addTitle(title: String) = apply { this.title = title }

        fun addLayoutId(layoutId: Int) = apply { this.layoutId = layoutId }

        fun addList(list: List<T>, variableId: Int? = null) = apply {
            this.list = list
            variableId?.let { this.variableId = it }
        }

        fun addExtraBinding(variableId: Int, value: Any) = apply {
            extraBindings.put(variableId, value)
        }

        fun build() =
            BottomSheetRecyclerView(context, title, layoutId, list, extraBindings, variableId)

    }
}