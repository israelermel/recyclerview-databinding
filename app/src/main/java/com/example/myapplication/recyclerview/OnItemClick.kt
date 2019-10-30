package com.example.myapplication.recyclerview

interface OnItemClick<T> {
    fun onSelectedItem(item: T): OnItemClick<T>?
}