package com.example.myapplication

import com.example.myapplication.commom.bePolite
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations.initMocks

class StringExtensionsTest {


    @Before
    fun setup() {
        initMocks(this)
    }

    @Test
    fun teste() {
        val teste: String = "Israel"
        Assert.assertEquals("Israel, please", teste.bePolite())
    }

}