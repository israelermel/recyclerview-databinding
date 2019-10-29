package com.example.myapplication.teste.builder

import kotlin.properties.Delegates

fun person(type: String, block: PersonBuilder.() -> Unit): Person =
    PersonBuilder(type).apply(block).build()

class PersonBuilder(private val type: String) {
    var name: String by Delegates.notNull()
    var age: Int by Delegates.notNull()

    fun build(): Person = Person(name, age, type)
}