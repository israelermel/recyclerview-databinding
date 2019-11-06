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

    private lateinit var singleAdapterRD: SingleAdapterListenerRD<T>

    private var btnClose: ImageButton? = null
    private var titleView: TextView? = null
    private var recyclerView: RecyclerView? = null
    private var extraBindings: SparseArray<Any>? = null
    private var itemLayoutId: Int? = null
    private var variableLayoutItem: Int? = null

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
        addItemLayoutId(layoutId)
        addVariableLayoutItem(variableLayout)
        configLayoutRecyclerView()
        addTitle(title)
        addExtraBind(extraBindings)
        setRecyclerViewList(listItem)
    }

    fun titleBottom(): String {
        return titleView?.text.toString()
    }

    fun itemCount(): Int {
        try {
            recyclerView?.let {
                return it.adapter!!.itemCount
            } ?: return 0
        } catch (e: KotlinNullPointerException) {
            return 0
        }
    }

    private fun addTitle(title: String?) {
        titleView!!.text = title
    }

    constructor(context: Context) : super(context, R.style.BottomSheetDialogTheme) {
        configLayoutRecyclerView()
    }

    private fun configLayoutRecyclerView() {
        val bottomSheetView = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
        setContentView(bottomSheetView)

        btnClose = findViewById(R.id.btn_close_bottom_sheet_rd)
        titleView = findViewById(R.id.txt_title_bottom_sheet)
        recyclerView = findViewById(R.id.rcv_bottom_sheet_custom)

        btnClose!!.setOnClickListener(this)
    }

    private fun addVariableLayoutItem(variableLayoutItem: Int?) {
        this.variableLayoutItem = variableLayoutItem
    }

    fun variableLayoutItem(): Int? {
        return variableLayoutItem
    }

    fun variableLayoutId(): Int {
        return singleAdapterRD.variableLayoutObject()
    }

    private fun addItemLayoutId(layoutId: Int? = null) {
        if (layoutId == null) {
            itemLayoutId = R.layout.item_textview_layout
        } else {
            this.itemLayoutId = layoutId
        }
    }

    fun layoutIdBottomSheet(): Int? {
        return itemLayoutId
    }

    private fun addExtraBind(extraBindings: SparseArray<Any>? = null) {
        extraBindings?.let {
            this.extraBindings = extraBindings
        }
    }

    fun extraBindItems(): SparseArray<Any>? {
        return extraBindings
    }

    private fun setRecyclerViewList(list: List<T>? = null) {
        list?.let {
            singleAdapterRD =
                SingleAdapterListenerRD(itemLayoutId!!, list, extraBindings, variableLayoutItem)

            recyclerView!!.adapter = singleAdapterRD
        }
    }

    override fun onClick(v: View) {
        dismiss()
    }

    fun isShowingBottom(): Boolean {
        return isShowing
    }

    data class Builder<T>(
        private var context: Context,
        private var title: String? = null,
        private var layoutId: Int? = null,
        private var list: List<T>? = null,
        private var extraBindings: SparseArray<Any> = SparseArray(),
        private var variableLayoutItem: Int? = null
    ) {
        fun addTitle(title: String) = apply { this.title = title }

        fun addLayoutId(layoutId: Int) = apply { this.layoutId = layoutId }

        fun addList(list: List<T>, variableLayoutItem: Int? = null) = apply {
            this.list = list
            variableLayoutItem?.let { this.variableLayoutItem = it }
        }

        fun addExtraBinding(variableExtraBind: Int, value: Any) = apply {
            extraBindings.put(variableExtraBind, value)
        }

        fun build() =
            BottomSheetRecyclerView(
                context,
                title,
                layoutId,
                list,
                extraBindings,
                variableLayoutItem
            )

    }
}