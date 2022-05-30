package com.example.thesimplestrv.nested

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesimplestrv.databinding.NestedListItemLayoutBinding
import com.example.thesimplestrv.model.NestedThing
import com.example.thesimplestrv.nested.NestedAdapter.NestedThingViewHolder


class NestedThingDiffCallback : DiffUtil.ItemCallback<NestedThing>() {
    override fun areItemsTheSame(oldItem: NestedThing, newItem: NestedThing) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NestedThing, newItem: NestedThing) =
        oldItem.id == newItem.id
                && oldItem.name == newItem.name
}

class NestedAdapter : ListAdapter<NestedThing, NestedThingViewHolder>(NestedThingDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedThingViewHolder {
        val binding =
            NestedListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NestedThingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NestedThingViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class NestedThingViewHolder(private val binding: NestedListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(thing: NestedThing) {
            binding.apply {
                itemName.text = thing.name
            }
        }
    }
}


