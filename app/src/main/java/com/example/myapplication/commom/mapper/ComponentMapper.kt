package com.example.myapplication.commom.mapper

class ComponentMapper {
    fun stringToComponent(component: String): ComponentRD {
        return when (component) {
            "TEXT_VIEW" -> ComponentRD.TextView
            "EDIT_TEXT" -> ComponentRD.EditText
            else -> ComponentRD.EditText
        }
    }
}