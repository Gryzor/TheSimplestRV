package com.example.thesimplestrv.listeners

import com.example.thesimplestrv.model.NestedThing

interface NestedThingClickListener {
    fun onNestedThingClicked(parentId: Int, thing: NestedThing)
}