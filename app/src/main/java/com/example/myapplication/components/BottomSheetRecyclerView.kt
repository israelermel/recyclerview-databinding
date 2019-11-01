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

    private lateinit var onItemClickBottomSheet: OnItemClick<T>

    private constructor(
        context: Context,
        title: String?,
        layoutId: Int?,
        list: List<T>?,
        extraBindings: SparseArray<Any>?
    ) : super(
        context,
        R.style.BottomSheetDialogTheme
    ) {
        layoutId?.let { addLayoutId(layoutId) } ?: addLayoutId(R.layout.item_textview_layout)

        setDialogView()

        title?.let { setTitle(it) }
        extraBindings?.let { addExtraBind(it) }
        list?.let { setRecyclerViewList(it) }
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
            SingleAdapterListenerRD(layoutIdBottom!!, list, extraBindings)

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
        private var extraBindings: SparseArray<Any> = SparseArray()
    ) {
        fun addTitle(title: String) = apply { this.title = title }
        fun addLayoutId(layoutId: Int) = apply { this.layoutId = layoutId }
        fun addList(list: List<T>) = apply { this.list = list }
        fun addExtraBinding(variableId: Int, value: Any) = apply {
            extraBindings.put(variableId, value)
        }

        fun build() = BottomSheetRecyclerView(context, title, layoutId, list, extraBindings)

    }
}