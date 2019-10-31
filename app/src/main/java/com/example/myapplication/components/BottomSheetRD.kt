package com.example.myapplication.components

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerview.OnItemClick
import com.example.myapplication.recyclerview.SingleAdapterListenerRD
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomSheetRD<T> : BottomSheetDialog, View.OnClickListener {

    private var btnClose: ImageButton? = null
    private var titleView: TextView? = null
    private var recyclerView: RecyclerView? = null

    private lateinit var onItemClickBottomSheet: OnItemClick<T>

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
            SingleAdapterListenerRD(R.layout.item_textview_layout, list, onItemClickBottomSheet)

        recyclerView!!.adapter = singleAdapterRD
    }

    override fun onClick(v: View) {
        dismiss()
    }
}