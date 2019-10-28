package com.example.myapplication.recyclerview.base

sealed class ComponentType {
    object EditText : ComponentType()
    object TextView : ComponentType()
}