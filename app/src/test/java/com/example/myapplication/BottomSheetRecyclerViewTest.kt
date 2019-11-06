package com.example.myapplication

import android.app.Activity
import com.example.myapplication.components.BottomSheetRecyclerView
import com.example.myapplication.enumteste.ComponentLayoutEnum
import com.example.myapplication.recyclerview.OnItemClick
import com.example.myapplication.recyclerview.RowRecyclerView
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.standalone.StandAloneContext
import org.mockito.Mockito.mock
import org.mockito.Mockito.spy
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController

@RunWith(RobolectricTestRunner::class)
class BottomSheetRecyclerViewTest {

    private val variableExtraBind: Int = 2
    private val bottomSheetTitle = "Bottom Sheet Test"
    private val layoutBottomSheetDefault = R.layout.item_textview_layout
    private val variableLayoutItem = 1

    private lateinit var activityController: ActivityController<Activity>
    private lateinit var activity: Activity

    private lateinit var bottomSheetRecyclerViewBuilder: BottomSheetRecyclerView.Builder<RowRecyclerView>

    private var listener = mock(OnItemClick::class.java)

    @Before
    fun setUp() {

        activityController = Robolectric.buildActivity(Activity::class.java)
        activity = activityController.get()

        bottomSheetRecyclerViewBuilder =
            spy(BottomSheetRecyclerView.Builder<RowRecyclerView>(activity))

    }

    @After
    fun tearDown() {
        StandAloneContext.stopKoin()
    }

    private fun getAllItems(): MutableList<RowRecyclerView> {
        val lista = mutableListOf<RowRecyclerView>()
        lista.add(RowRecyclerView("israel1", ComponentLayoutEnum.EDIT_TEXT))
        lista.add(RowRecyclerView("israel2", ComponentLayoutEnum.EDIT_TEXT))
        lista.add(RowRecyclerView("israel3", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel4", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel5", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel6", ComponentLayoutEnum.TEXT_VIEW))
        lista.add(RowRecyclerView("israel7", ComponentLayoutEnum.TEXT_VIEW))

        return lista
    }

    @Test
    fun givenBottomTitle_shouldHasTitleOnComponent() {
        //GIVEN

        var bottomSheetRecyclerView = spy(
            bottomSheetRecyclerViewBuilder
                .addTitle(bottomSheetTitle)
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(bottomSheetTitle, bottomSheetRecyclerView.titleBottom())

    }

    @Test
    fun givenTitleEmpty_shouldNotHasTitleOnComponent() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            bottomSheetRecyclerViewBuilder
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals("", bottomSheetRecyclerView.titleBottom())

    }

    @Test
    fun givenListItems_shouldHasSameCountOfItemsOnComponent() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems())
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(getAllItems().size, bottomSheetRecyclerView.itemCount())

    }

    @Test
    fun givenListItemsEmpty_shouldHasEmptyListOnComponent() {

        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(0, bottomSheetRecyclerView.itemCount())

    }

    @Test
    fun givenAnythingWithLayout_shouldHasReturnDefaultLayout() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems())
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(layoutBottomSheetDefault, bottomSheetRecyclerView.layoutIdBottomSheet())
    }

    @Test
    fun givenNothingWithLayoutVariable_shouldHasReturnLayoutVariableDefault() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems())
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(BR.obj, bottomSheetRecyclerView.variableLayoutId())
    }


    @Test
    fun givenLayoutId_shouldHasReturnSameLayout() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addLayoutId(BR.obj)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems())
                .build()
        )

        //WHEN
        bottomSheetRecyclerView.show()

        //THEN
        assertEquals(BR.obj, bottomSheetRecyclerView.variableLayoutId())
    }

    @Test
    fun givenVariableLayoutItem_shouldReturnSameLayoutItem() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addLayoutId(BR.obj)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems(), variableLayoutItem)
                .build()
        )

        //THEN
        assertEquals(variableLayoutItem, bottomSheetRecyclerView.variableLayoutItem())
    }

    @Test
    fun givenVariableExtraBindListener_shouldReturnSameListener() {
        //GIVEN
        var bottomSheetRecyclerView = spy(
            BottomSheetRecyclerView.Builder<RowRecyclerView>(activity)
                .addTitle(bottomSheetTitle)
                .addList(getAllItems())
                .addExtraBinding(variableExtraBind, listener)
                .build()
        )

        //THEN
        assertEquals(variableExtraBind, bottomSheetRecyclerView.extraBindItems()?.keyAt(0))
        assertSame(listener, bottomSheetRecyclerView.extraBindItems()?.valueAt(0))
    }


}