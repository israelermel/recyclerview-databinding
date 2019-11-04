package com.example.myapplication.commom.mapper

sealed class ComponentRD {
    object TextView : ComponentRD()
    object EditText : ComponentRD()
}