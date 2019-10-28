package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.databinding.CreateBinding
import com.example.myapplication.recyclerview.ListaViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: CreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.lista)

        binding = DataBindingUtil.setContentView(this, R.layout.lista)
        binding.viewModel = ListaViewModel()
        binding.executePendingBindings()

//        setContentView(R.layout.activity_main)

//        btn_bottom_sheet.setOnClickListener {
//
//            val bottomSheetFragment = BottomSheetFragment()
//
//            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
//        }


    }
}
