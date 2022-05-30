package com.example.thesimplestrv.nested

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesimplestrv.databinding.ClearedNestedListItemLayoutBinding
import com.example.thesimplestrv.databinding.SelectedNestedListItemLayoutBinding
import com.example.thesimplestrv.listeners.ThingClickListener
import com.example.thesimplestrv.model.NestedThing


class NestedAdapter(private val clickListener: ThingClickListener) :
    ListAdapter<NestedThing, RecyclerView.ViewHolder>(NestedThingDiffCallback()) {

    override fun getItemViewType(position: Int) = getItem(position).isSelected.toInt()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            1 -> {
                SelectedViewHolder(
                    SelectedNestedListItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), clickListener
                )
            }
            else -> {
                ClearViewHolder(
                    ClearedNestedListItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ), clickListener
                )
            }
        }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = getItem(position)
        (holder as SelectableViewHolder<*>).bind(currentItem)
    }

    private fun Boolean.toInt() = if (this) 1 else 0
}


