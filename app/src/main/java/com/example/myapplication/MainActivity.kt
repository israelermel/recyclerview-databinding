package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.components.BottomSheetRD
import com.example.myapplication.databinding.CreateBinding
import com.example.myapplication.recyclerview.ListaViewModel
import com.example.myapplication.recyclerview.OnItemClick
import com.example.myapplication.recyclerview.RowRecyclerView
import com.example.myapplication.recyclerview.base.ComponentType
import com.example.myapplication.teste.builder.person
import kotlinx.android.synthetic.main.lista.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: CreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.lista)
        binding.viewModel = ListaViewModel()
        binding.executePendingBindings()

//        exemplo()

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
//            Log.e("israel", ex.message)
        }

    }

    fun exemplo() {
        val me = person("fisica") {
            name = "israel"
            age = 33
        }
    }

    private fun onItemClickBottomSheet(): OnItemClick<RowRecyclerView> {
        return object : OnItemClick<RowRecyclerView> {
            override fun onSelectedItem(item: RowRecyclerView): OnItemClick<RowRecyclerView>? {
                Log.d("israel", item.nome)
                return this
            }
        }
    }


}
