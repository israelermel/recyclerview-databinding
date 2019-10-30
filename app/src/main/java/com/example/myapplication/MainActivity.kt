package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.components.BottomSheetRD
import com.example.myapplication.components.OnClickBottomSheetRD
import com.example.myapplication.recyclerview.ListaViewModel
import com.example.myapplication.recyclerview.RowRecyclerView
import com.example.myapplication.recyclerview.base.ComponentType
import com.example.myapplication.recyclerview.base.OnItemClickRownRecyclerView
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

            val lista = mutableListOf<RowRecyclerView>()
            lista.add(RowRecyclerView("israel1", ComponentType.EditText))
            lista.add(RowRecyclerView("israel2", ComponentType.EditText))
            lista.add(RowRecyclerView("israel3", ComponentType.EditText))
            lista.add(RowRecyclerView("israel4", ComponentType.TextView))
            lista.add(RowRecyclerView("israel5", ComponentType.TextView))
            lista.add(RowRecyclerView("israel6", ComponentType.TextView))
            lista.add(RowRecyclerView("israel7", ComponentType.TextView))

            btn_open_dialog.setOnClickListener {
                val bottomSheetRD = BottomSheetRD(this, onItemClickBottomSheet())
                bottomSheetRD.setTitle("Titulo para Teste")
                bottomSheetRD.setRecyclerViewList(lista)
                bottomSheetRD.show()
            }

        } catch (ex: Exception) {
            Log.e("israel", ex.message)
        }

    }

    private fun onItemClickBottomSheet(): OnItemClickRownRecyclerView {
        return object : OnItemClickRownRecyclerView {
            override fun onSelected(item: RowRecyclerView) {
                Log.d("israel", item.nome)
            }
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
