package com.example.thesimplestrv.repository

import com.example.thesimplestrv.model.NestedThing
import com.example.thesimplestrv.model.Student

class FakeStudentRepository {
    private var cachedStudentList: MutableList<Student> = mutableListOf()

    fun fetchStudents(): MutableList<Student> {
        // In a real app, you'd likely use a `flow` or similar and use this as the single source
        // of truth. When a change is needed (e.g. when something is selected) this list should
        // be updated and propagated down to the viewModel and later Fragment.
        // In this "simple" example, we skip all that and simply construct the list once and return
        // it.
        // The issue with this simplification is that when the ViewModel needs to change something
        // it does so in its own copy, which is not correct, because if/when the VM is cleared, its
        // contents won't be stored here and will be lost.
        if (cachedStudentList.isEmpty()) {
            cachedStudentList = mutableListOf(
                Student(1, "One", makeRandomInnerThings(1)),
                Student(2, "Two", makeRandomInnerThings(2)),
                Student(3, "Three", makeRandomInnerThings(3)),
                Student(4, "Four", makeRandomInnerThings(4)),
                Student(5, "Five", makeRandomInnerThings(5)),
                Student(6, "Six", makeRandomInnerThings(6)),
                Student(7, "Seven", makeRandomInnerThings(7)),
                Student(8, "Eight", makeRandomInnerThings(8)),
                Student(9, "Nine", makeRandomInnerThings(9)),
                Student(10, "Ten", makeRandomInnerThings(10)),
                Student(11, "Eleven", makeRandomInnerThings(11)),
                Student(12, "Twelve", makeRandomInnerThings(12)),
                Student(13, "Thirteen", makeRandomInnerThings(13)),
                Student(14, "Fourteen", makeRandomInnerThings(14)),
            )
        }

        return cachedStudentList.toMutableList()
    }

    private fun makeRandomInnerThings(parentId: Int): MutableList<NestedThing> {
        val totalItems = (1..20).random()
        val innerList = mutableListOf<NestedThing>()

        for (i in 1..totalItems) {
            innerList.add(
                NestedThing(i, i.toString(), parentId)
            )
        }

        return innerList
    }
}