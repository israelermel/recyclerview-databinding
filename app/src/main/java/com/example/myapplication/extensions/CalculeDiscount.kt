package com.example.myapplication.extensions

class CalculeDiscount {

    fun calculateDiscount(pessoa: Pessoa): Int {
        return when {
            pessoa.acima65() -> 20
            pessoa.abaixo13() -> 10
            pessoa.isRich() -> 0
            else -> 5
        }
    }
}