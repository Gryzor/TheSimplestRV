package com.example.thesimplestrv.outer

import androidx.recyclerview.widget.DiffUtil
import com.example.thesimplestrv.model.Student

class StudentDiffCallback : DiffUtil.ItemCallback<Student>() {
    override fun areItemsTheSame(oldItem: Student, newItem: Student) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Student, newItem: Student) =
        oldItem.name == newItem.name && oldItem.nestedThings == newItem.nestedThings
}