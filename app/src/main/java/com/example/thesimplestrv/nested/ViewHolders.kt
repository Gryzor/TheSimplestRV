package com.example.thesimplestrv.nested

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.thesimplestrv.databinding.ClearedNestedListItemLayoutBinding
import com.example.thesimplestrv.databinding.SelectedNestedListItemLayoutBinding
import com.example.thesimplestrv.listeners.ThingClickListener
import com.example.thesimplestrv.model.NestedThing

abstract class SelectableViewHolder<Binding : ViewBinding>(binding: Binding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(thing: NestedThing)
}

class SelectedViewHolder(
    private val binding: SelectedNestedListItemLayoutBinding,
    private val clickListener: ThingClickListener
) :
    SelectableViewHolder<SelectedNestedListItemLayoutBinding>(binding) {

    override fun bind(thing: NestedThing) {
        binding.apply {
            itemName.text = thing.name
            itemName.setOnClickListener {
                clickListener.onThingClicked(thing)
            }
        }
    }
}

class ClearViewHolder(
    private val binding: ClearedNestedListItemLayoutBinding,
    private val clickListener: ThingClickListener
) :
    SelectableViewHolder<ClearedNestedListItemLayoutBinding>(binding) {

    override fun bind(thing: NestedThing) {
        binding.apply {
            itemName.text = thing.name
            itemName.setOnClickListener {
                clickListener.onThingClicked(thing)
            }
        }
    }
}
