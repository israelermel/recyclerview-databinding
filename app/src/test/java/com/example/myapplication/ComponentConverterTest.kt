package com.example.myapplication

import com.example.myapplication.commom.mapper.ComponentConverter
import com.example.myapplication.commom.mapper.ComponentMapper
import com.example.myapplication.commom.mapper.ComponentRD
import com.example.myapplication.commom.mapper.LayoutMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class ComponentConverterTest {

    @Mock
    lateinit var componentConverter: ComponentConverter

    @Mock
    lateinit var componentMapper: ComponentMapper

    @Mock
    lateinit var layoutMapper: LayoutMapper

    val textViewComponent = "TEXT_VIEW"
    val editTextComponent = "EDIT_TEXT"

    @Before
    fun setup() {
        initMocks(this)

        componentConverter = ComponentConverter(componentMapper, layoutMapper)
    }

    @Test
    fun givenTextViewString_shouldConvertToLayoutId() {

        //GIVEN
        given(componentMapper.stringToComponent(textViewComponent)).willReturn(ComponentRD.TextView)
        given(layoutMapper.toLayoutId(ComponentRD.TextView)).willReturn(R.layout.textview_layout)

        //WHEN
        val layoutId = componentConverter.toLayout(textViewComponent)

        //THEN
        assertEquals(R.layout.textview_layout, layoutId)
    }


    @Test
    fun givenEditTextString_shouldConvertToLayoutId() {

        //GIVEN
        given(componentMapper.stringToComponent(editTextComponent)).willReturn(ComponentRD.EditText)
        given(layoutMapper.toLayoutId(ComponentRD.EditText)).willReturn(R.layout.edittext_layout)

        //WHEN
        val layoutId = componentConverter.toLayout(editTextComponent)

        //THEN
        assertEquals(R.layout.edittext_layout, layoutId)
    }

    @Test
    fun givenEditText_shouldNotReturnTextViewLayoutId() {

        //GIVEN
        given(componentMapper.stringToComponent(editTextComponent)).willReturn(ComponentRD.EditText)
        given(layoutMapper.toLayoutId(ComponentRD.EditText)).willReturn(R.layout.edittext_layout)

        //WHEN
        val layoutId = componentConverter.toLayout(editTextComponent)

        //THEN
        assertNotEquals(R.layout.textview_layout, layoutId)
    }


    @Test
    fun givenTextViewString_shouldNotReturnEditTextLayoutId() {

        //GIVEN
        given(componentMapper.stringToComponent(textViewComponent)).willReturn(ComponentRD.TextView)
        given(layoutMapper.toLayoutId(ComponentRD.TextView)).willReturn(R.layout.textview_layout)

        //WHEN
        val layoutId = componentConverter.toLayout(textViewComponent)

        //THEN
        assertNotEquals(R.layout.edittext_layout, layoutId)
    }

}