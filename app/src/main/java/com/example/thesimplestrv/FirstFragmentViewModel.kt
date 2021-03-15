package com.example.thesimplestrv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class FirstFragmentViewModel : ViewModel() {
    private var demoList = mutableListOf(
        DemoModel(1, "One", true),
        DemoModel(2, "Two", true),
        DemoModel(3, "Three", true),
        DemoModel(4, "Four", true),
        DemoModel(5, "Five", true),
        DemoModel(6, "Six", true),
        DemoModel(7, "Seven", true),
        DemoModel(8, "Eight", true)
    )

    var demoLiveData = MutableLiveData(demoList.toList())

    fun randomPosition(): Int {
        return Random.nextInt(demoList.size)
    }

    fun updateData(pos: Int, newName: String) {
        val old = demoList[pos]
        val new = DemoModel(old.id, old.name, old.visible)
        new.name = newName
        demoList.removeAt(pos)
        demoList.add(pos, new)
        demoLiveData.postValue(demoList.toList())
    }

    fun deleteData(pos: Int) {
        demoList.removeAt(pos)
        demoLiveData.postValue(demoList.toList())
    }
}