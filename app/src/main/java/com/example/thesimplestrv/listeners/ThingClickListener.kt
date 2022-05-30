package com.example.thesimplestrv.listeners

import com.example.thesimplestrv.model.NestedThing

interface ThingClickListener {
    fun onThingClicked(thing: NestedThing)
}