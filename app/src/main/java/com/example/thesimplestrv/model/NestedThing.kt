package com.example.thesimplestrv.model

data class NestedThing(
    val id: Int,
    var name: String,
    val parentId: Int,
    val isSelected: Boolean = false
)