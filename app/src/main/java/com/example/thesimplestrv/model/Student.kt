package com.example.thesimplestrv.model

data class Student(
    val id: Int,
    var name: String,
    val nestedThings: List<NestedThing> = mutableListOf()
)