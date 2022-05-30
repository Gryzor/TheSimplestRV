package com.example.thesimplestrv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thesimplestrv.model.DemoModel
import com.example.thesimplestrv.model.NestedThing
import kotlin.random.Random

class FirstFragmentViewModel : ViewModel() {
    private var demoList = mutableListOf(
        DemoModel(1, "One", true, makeRandomInnerThings()),
        DemoModel(2, "Two", true, makeRandomInnerThings()),
        DemoModel(3, "Three", true, makeRandomInnerThings()),
        DemoModel(4, "Four", true, makeRandomInnerThings()),
        DemoModel(5, "Five", true, makeRandomInnerThings()),
        DemoModel(6, "Six", true, makeRandomInnerThings()),
        DemoModel(7, "Seven", true, makeRandomInnerThings()),
        DemoModel(8, "Eight", true, makeRandomInnerThings())
    )

    private fun makeRandomInnerThings(): List<NestedThing> {
        val totalItems = (1..20).random()
        val innerList = mutableListOf<NestedThing>()

        for (i in 1..totalItems) {
            innerList.add(
                NestedThing(i, i.toString())
            )
        }
        return innerList.toList()
    }

    var demoLiveData = MutableLiveData(demoList.toList())

    fun randomPosition(): Int {
        return Random.nextInt(demoList.size)
    }

    fun updateData(pos: Int, newName: String) {
        val old = demoList[pos]
        demoList.removeAt(pos)
        val new = old.copy(id = old.id, name = newName, visible = old.visible)
        demoList.add(pos, new)
        demoLiveData.postValue(demoList.toList())
    }

    fun deleteData(pos: Int) {
        demoList.removeAt(pos)
        demoLiveData.postValue(demoList.toList())
    }
}