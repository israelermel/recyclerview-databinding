package com.example.myapplication.commom.mapper

class ComponentConverter(
    private val componentMapper: ComponentMapper,
    private val layoutMapper: LayoutMapper
) {

    fun toLayout(component: String): Int {
        val componentRD = componentMapper.stringToComponent(component)
        return layoutMapper.toLayoutId(componentRD)
    }
}
