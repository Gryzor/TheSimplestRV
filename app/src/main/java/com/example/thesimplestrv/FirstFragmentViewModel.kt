package com.example.thesimplestrv

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
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

    fun deleteDataAtRandomPosition() {
        val randomPosition = randomPosition()

        if (isPositionValid(randomPosition, demoList)) {
            deleteData(pos = randomPosition)
        }
    }

    fun updateDataAtRandomPosition(newName: String) {
        val randomPosition = randomPosition()

        if (isPositionValid(randomPosition, demoList)) {
            updateData(pos = randomPosition, newName = newName)
        }
    }

    private fun isPositionValid(pos: Int, list: List<DemoModel>): Boolean =
        (list.size <= pos || pos == RecyclerView.NO_POSITION).not()

    private fun randomPosition(): Int {
        if (demoList.isEmpty()) {
            return RecyclerView.NO_POSITION
        }

        return Random.nextInt(demoList.size)
    }

    private fun updateData(pos: Int, newName: String) {
        val old = demoList[pos]
        demoList.removeAt(pos)
        val new = old.copy(id = old.id, name = newName, visible = old.visible)
        demoList.add(pos, new)
        demoLiveData.postValue(demoList.toList())
    }

    private fun deleteData(pos: Int) {
        demoList.removeAt(pos)
        demoLiveData.postValue(demoList.toList())
    }
}