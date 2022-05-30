package com.example.thesimplestrv.listeners

import com.example.thesimplestrv.model.NestedThing

fun interface ThingClickListener {
    fun onThingClicked(thing: NestedThing)
}