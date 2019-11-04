package com.example.myapplication.commom.mapper

import com.example.myapplication.R

class LayoutMapper {
    fun toLayoutId(componentRD: ComponentRD): Int {
        return when (componentRD) {
            is ComponentRD.EditText -> R.layout.edittext_layout
            is ComponentRD.TextView -> R.layout.textview_layout
        }
    }

}