package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.components.BottomSheetRD
import com.example.myapplication.components.OnClickBottomSheetRD
import com.example.myapplication.databinding.CreateBinding
import com.example.myapplication.recyclerview.ListaViewModel
import kotlinx.android.synthetic.main.lista.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: CreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.lista)

        binding = DataBindingUtil.setContentView(this, R.layout.lista)
        binding.viewModel = ListaViewModel()
        binding.executePendingBindings()

        /*
          val me = person("fisica") {
              name = "israel"
              age = 33
          }
          */


//        setContentView(R.layout.activity_main)

//        btn_bottom_sheet.setOnClickListener {
//
//            val bottomSheetFragment = BottomSheetFragment()
//
//            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
//        }

        try {
            btn_open_dialog.setOnClickListener {
                val bottomSheetRD = BottomSheetRD(this, onClickBottomSheet())
                bottomSheetRD.show()
            }
        } catch (ex: Exception) {
            Log.e("israel", ex.message)
        }


    }

    private fun onClickBottomSheet(): OnClickBottomSheetRD {
        return object : OnClickBottomSheetRD {
            override fun onSelected() {
                Log.d("israel", "onSelected")
            }

            override fun onClose() {
                Log.d("israel", "onClose")
            }
        }
    }

}
