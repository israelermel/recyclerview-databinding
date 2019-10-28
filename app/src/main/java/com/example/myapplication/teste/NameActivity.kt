package com.example.myapplication.teste

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplication.R
import com.example.myapplication.databinding.NameActivityBinding
import kotlinx.android.synthetic.main.name_activity.*
import org.koin.android.viewmodel.ext.android.getViewModel

class NameActivity : AppCompatActivity() {

    private lateinit var model: NameViewModel
    private lateinit var binding: NameActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.name_activity)
        binding.lifecycleOwner = this
        model = getViewModel()
        binding.viewModel = model

        val nameObserver = Observer<String> { newName ->
            nameTextView.text = newName
        }

        val edtNameObserver = Observer<String> { name ->
            model.currentName.postValue(name)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
        model.edtName.observe(this, edtNameObserver)

        button.setOnClickListener {
            val anotherName = "Israel Ermel"
            model.currentName.value = anotherName
        }

    }

}