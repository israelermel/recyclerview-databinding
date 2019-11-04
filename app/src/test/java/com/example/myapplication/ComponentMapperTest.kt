package com.example.myapplication

import com.example.myapplication.commom.mapper.ComponentMapper
import com.example.myapplication.commom.mapper.ComponentRD
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations.initMocks

class ComponentMapperTest {

    @Mock
    private lateinit var componentMapper: ComponentMapper

    @Mock
    private lateinit var componentRD: ComponentRD

    @Before
    fun setup() {
        initMocks(this)

        componentMapper = ComponentMapper()

    }

    @Test
    fun givenTextView_shouldReturnTextViewComponentMap() {
        //GIVEN
        val componentToMapper = "TEXT_VIEW"

        //WHEN
        val mapToComponent = componentMapper.stringToComponent(componentToMapper)

        //THEN
//        assertNotNull(mapToComponent)
        assertEquals(ComponentRD.TextView, mapToComponent)
    }

    @Test
    fun givenEditText_shouldReturnEditTextComponentMap() {
        //GIVEN
        val componentToMapper = "EDIT_TEXT"

        //WHEN
        val mapToComponent = componentMapper.stringToComponent(componentToMapper)

        //THEN
        assertNotNull(mapToComponent)
        assertEquals(ComponentRD.EditText, mapToComponent)
    }

    @Test
    fun givenEditText_shouldNotReturnTextViewComponentMap() {
        //GIVEN
        val componentToMapper = "EDIT_TEXT"

        //WHEN
        val mapToComponent = componentMapper.stringToComponent(componentToMapper)

        //THEN
        assertNotNull(mapToComponent)
        assertNotEquals(ComponentRD.TextView, mapToComponent)
    }

    @Test
    fun givenTextView_shouldNotReturnEditTextComponentMap() {
        //GIVEN
        val componentToMapper = "TEXT_VIEW"

        //WHEN
        val mapToComponent = componentMapper.stringToComponent(componentToMapper)

        //THEN
        assertNotNull(mapToComponent)
        assertNotEquals(ComponentRD.EditText, mapToComponent)
    }
}
