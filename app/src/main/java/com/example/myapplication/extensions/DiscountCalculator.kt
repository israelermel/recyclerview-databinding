package com.example.myapplication.extensions

class DiscountCalculator {

}

fun Pessoa.acima65(): Boolean {
    return this.idade > 65
}

fun Pessoa.abaixo13(): Boolean {
    return this.idade < 13
}

fun Pessoa.isRich(): Boolean {
    return this.renda > 1_000_000
}