package com.example.thesimplestrv.nested

import androidx.recyclerview.widget.DiffUtil
import com.example.thesimplestrv.model.NestedThing

class NestedThingDiffCallback : DiffUtil.ItemCallback<NestedThing>() {
    override fun areItemsTheSame(oldItem: NestedThing, newItem: NestedThing) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: NestedThing, newItem: NestedThing) =
        oldItem.name == newItem.name
                && oldItem.parentId == newItem.parentId
                && oldItem.isSelected == newItem.isSelected
}