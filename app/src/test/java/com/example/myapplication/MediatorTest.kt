package com.example.myapplication

import com.example.myapplication.extensions.CalculeDiscount
import com.example.myapplication.extensions.Pessoa
import com.example.myapplication.pattern.mediator.ChatMediator
import com.example.myapplication.pattern.mediator.ChatUser
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals as assertEquals1

class MediatorTest {


    @Before
    fun setup() {
    }

    @Test
    fun test_mediator() {
        val mediator = ChatMediator()
        val israel = ChatUser(mediator, "Israel")

        mediator
            .addUser(ChatUser(mediator, "Alice"))
            .addUser(ChatUser(mediator, "Bob"))
            .addUser(israel)

        israel.send("Ola a todos!")


    }


    @Test
    fun test_equals() {

        val intList = listOf(1, 2, 3, 4, 5, 6)
        val count = intList.filter { x -> x % 2 == 0 }.count()

        assertEquals1(3, count)


    }

    @Test
    fun teste2() {

        var pessoa = Pessoa("israel", 20, 10000000)
        val calculeDiscount = CalculeDiscount()

        val calculateDiscount = calculeDiscount.calculateDiscount(pessoa)


        assertEquals(5, calculateDiscount)
    }


}