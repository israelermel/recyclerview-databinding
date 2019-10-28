package com.example.myapplication

import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior

@BindingAdapter("bottomSheetCallback")
fun setBottomSheetCallback(
    view: View,
    bottomSheetCallback: BottomSheetBehavior.BottomSheetCallback
) {
    val viewBottomSheetBehavior = BottomSheetBehavior.from(view)
    viewBottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback)

    viewBottomSheetBehavior.isHideable = true
    viewBottomSheetBehavior.peekHeight = 90
}