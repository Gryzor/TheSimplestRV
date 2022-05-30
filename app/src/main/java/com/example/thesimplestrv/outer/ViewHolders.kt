package com.example.thesimplestrv.outer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thesimplestrv.R
import com.example.thesimplestrv.databinding.ListItemLayoutBinding
import com.example.thesimplestrv.listeners.NestedThingClickListener
import com.example.thesimplestrv.listeners.ThingClickListener
import com.example.thesimplestrv.model.NestedThing
import com.example.thesimplestrv.model.Student
import com.example.thesimplestrv.nested.NestedAdapter

class StudentViewHolder(
    private val binding: ListItemLayoutBinding,
    innerClickListener: NestedThingClickListener
) :
    RecyclerView.ViewHolder(binding.root) {

    private val clickListener = object : ThingClickListener {
        override fun onThingClicked(thing: NestedThing) {
            innerClickListener.onNestedThingClicked(thing.parentId, thing)
        }
    }

    private val innerAdapter = NestedAdapter(clickListener)

    init {
        binding.itemNestedList.layoutManager =
            LinearLayoutManager(
                binding.itemNestedList.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        binding.itemNestedList.adapter = innerAdapter
    }

    fun bind(student: Student) {
        binding.apply {
            itemName.text = binding.itemName.resources.getString(
                R.string.item_name_template,
                student.name
            )

            innerAdapter.submitList(student.nestedThings)
        }
    }
}