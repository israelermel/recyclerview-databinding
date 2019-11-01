package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.components.BottomSheetRecyclerView
import com.example.myapplication.databinding.CreateBinding
import com.example.myapplication.enumteste.ComponentLayoutEnum
import com.example.myapplication.recyclerview.ListaViewModel
import com.example.myapplication.recyclerview.OnItemClick
import com.example.myapplication.recyclerview.RowRecyclerView
import com.example.myapplication.teste.builder.person
import kotlinx.android.synthetic.main.lista.*

class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheet: BottomSheetRecyclerView<RowRecyclerView>
    lateinit var binding: CreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.lista)
        binding.viewModel = ListaViewModel()
        binding.executePendingBindings()

//        exemplo()

        try {

            val lista = mutableListOf<RowRecyclerView>()
            lista.add(RowRecyclerView("israel1", ComponentLayoutEnum.EDIT_TEXT))
            lista.add(RowRecyclerView("israel2", ComponentLayoutEnum.EDIT_TEXT))
            lista.add(RowRecyclerView("israel3", ComponentLayoutEnum.TEXT_VIEW))
            lista.add(RowRecyclerView("israel4", ComponentLayoutEnum.TEXT_VIEW))
            lista.add(RowRecyclerView("israel5", ComponentLayoutEnum.TEXT_VIEW))
            lista.add(RowRecyclerView("israel6", ComponentLayoutEnum.TEXT_VIEW))
            lista.add(RowRecyclerView("israel7", ComponentLayoutEnum.TEXT_VIEW))

            btn_open_dialog.setOnClickListener {
                openBottomSheet(lista)
            }

        } catch (ex: Exception) {
//            Log.e("israel", ex.message)
        }

    }

    private fun openBottomSheet(lista: MutableList<RowRecyclerView>) {
        bottomSheet = BottomSheetRecyclerView.Builder<RowRecyclerView>(this)
            .addTitle("Bottom Sheet Test")
            .addList(lista, BR.customer)
            .addExtraBinding(BR.listener, onItemClick())
            .build()

        bottomSheet.show()
    }

    private fun onItemClick(): OnItemClick<RowRecyclerView> {
        return object : OnItemClick<RowRecyclerView> {
            override fun onSelectedItem(item: RowRecyclerView) {
                bottomSheet.dismiss()
                Log.d("israel", "selecionado - ${item.nome}")
            }
        }
    }

    fun exemplo() {
        val me = person("fisica") {
            name = "israel"
            age = 33
        }
    }


}
