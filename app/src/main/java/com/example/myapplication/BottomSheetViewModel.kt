package com.example.myapplication

import android.util.Log
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

class BottomSheetViewModel {

    val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(view: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_HIDDEN -> {
                    Log.d("israel", "STATE_HIDDEN")
                }
                BottomSheetBehavior.STATE_EXPANDED ->
                    Log.d("israel", "STATE_EXPANDED")
                BottomSheetBehavior.STATE_COLLAPSED ->
                    Log.d("israel", "STATE_COLLAPSED")
                BottomSheetBehavior.STATE_DRAGGING -> {
                    Log.d("israel", "STATE_DRAGGING")
                }
                BottomSheetBehavior.STATE_SETTLING -> {
                    Log.d("israel", "STATE_SETTLING")
                }
                BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                    Log.d("israel", "STATE_HALF_EXPANDED")
                }
            }
        }

        override fun onSlide(p0: View, p1: Float) {

        }
    }
}