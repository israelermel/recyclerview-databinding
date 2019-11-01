package com.example.myapplication.enumteste

import com.example.myapplication.R
import com.google.gson.annotations.SerializedName

enum class ComponentLayoutEnum(var layoutId: Int) {
    @SerializedName("EDIT_TEXT")
    EDIT_TEXT(R.layout.edittext_layout),
    @SerializedName("TEXT_VIEW")
    TEXT_VIEW(R.layout.textview_layout),
    @SerializedName("TEXT_VIEW2232323")
    TEXT_VIEW2(R.layout.textview_layout)
}