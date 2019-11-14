package com.example.core

interface DomainMappable<R> {
    fun asDomain(): R
}