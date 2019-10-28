package com.example.myapplication.recyclerview.base

import com.example.myapplication.R

class ComponentTypeImpl {

    fun component(component: ComponentType): Int {
        return when (component) {
            is ComponentType.EditText -> {
                R.layout.edittext_layout
            }

            is ComponentType.TextView -> {
                R.layout.textview_layout
            }

        }
    }

}