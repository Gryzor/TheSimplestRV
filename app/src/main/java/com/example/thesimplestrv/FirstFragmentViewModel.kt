package com.example.thesimplestrv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.thesimplestrv.model.NestedThing
import com.example.thesimplestrv.model.Student
import com.example.thesimplestrv.repository.FakeStudentRepository
import kotlin.random.Random

class FirstFragmentViewModel : ViewModel() {
    private val studentRepository = FakeStudentRepository()
    private var studentList = studentRepository.fetchStudents()
    private var _studentsLiveData = MutableLiveData(studentList.toList())
    var studentsLiveData: LiveData<List<Student>> = _studentsLiveData

    fun randomPosition(): Int {
        return Random.nextInt(studentList.size)
    }

    fun updateData(pos: Int, newName: String) {
        val old = studentList[pos]
        studentList.removeAt(pos)
        val new = old.copy(id = old.id, name = newName)
        studentList.add(pos, new)
        _studentsLiveData.postValue(studentList.toList())
    }

    fun deleteData(pos: Int) {
        studentList.removeAt(pos)
        _studentsLiveData.postValue(studentList.toList())
    }

    fun onNestedThingClicked(parentId: Int, thing: NestedThing) {
        // Simulate something was "selected"
        val parent = studentList.find { it.id == parentId } ?: return
        val parentPos = studentList.indexOf(parent)

        val newThingsList = parent.nestedThings.toMutableList()
        val thingPos = newThingsList.indexOf(thing)

        val item = newThingsList.find { it == thing } ?: return
        val newItem = item.copy(isSelected = item.isSelected.not())
        newThingsList[thingPos] = newItem

        val newParent = parent.copy(nestedThings = newThingsList)

        studentList[parentPos] = newParent

        _studentsLiveData.postValue(studentList.toList())
    }
}