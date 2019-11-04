package com.example.myapplication

import com.example.myapplication.commom.mapper.ComponentRD
import com.example.myapplication.commom.mapper.LayoutMapper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class LayoutMapperTest {

    @Mock
    private lateinit var layoutMapper: LayoutMapper


    @Before
    fun setup() {
        initMocks(this)
    }

    @Test
    fun givenComponentRDTextView_shouldReturnTextViewLayout() {
        //GIVEN
        val componentRD = ComponentRD.TextView

        //WHEN
        val layoutId = layoutMapper.toLayoutId(componentRD)

        //THEN
        Assert.assertEquals(R.layout.textview_layout, layoutId)
    }

    @Test
    fun givenComponentRDEditText_shouldReturnEditTextLayout() {
        //GIVEN
        val componentRD = ComponentRD.EditText

        //WHEN
        val layoutId = layoutMapper.toLayoutId(componentRD)

        //THEN
        Assert.assertEquals(R.layout.edittext_layout, layoutId)
    }

    @Test
    fun givenComponentRDTextView_shouldNotReturnEditTextLayout() {
        //GIVEN
        val componentRD = ComponentRD.TextView

        //WHEN
        val layoutId = layoutMapper.toLayoutId(componentRD)

        //THEN
        Assert.assertNotEquals(R.layout.edittext_layout, layoutId)
    }

    @Test
    fun givenComponentRDEditText_shouldNotReturnTextViewLayout() {
        //GIVEN
        val componentRD = ComponentRD.EditText

        //WHEN
        val layoutId = layoutMapper.toLayoutId(componentRD)

        //THEN
        Assert.assertNotEquals(R.layout.textview_layout, layoutId)
    }

}