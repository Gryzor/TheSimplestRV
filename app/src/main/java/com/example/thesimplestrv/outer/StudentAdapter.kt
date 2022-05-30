package com.example.thesimplestrv.outer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.thesimplestrv.databinding.ListItemLayoutBinding
import com.example.thesimplestrv.listeners.NestedThingClickListener
import com.example.thesimplestrv.model.Student

class StudentAdapter(private val innerClickListener: NestedThingClickListener) :
    ListAdapter<Student, StudentViewHolder>(StudentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding =
            ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding, innerClickListener)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}


