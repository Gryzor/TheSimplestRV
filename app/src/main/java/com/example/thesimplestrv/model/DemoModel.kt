package com.example.thesimplestrv.model

data class DemoModel(val id: Int, var name: String, val visible: Boolean = true, val nestedThings: List<NestedThing> = emptyList())