package com.example.thesimplestrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesimplestrv.databinding.ListItemLayoutBinding

data class DemoModel(val id: Int, var name: String, val visible: Boolean = true)

class DiffCallback : DiffUtil.ItemCallback<DemoModel>() {
    override fun areItemsTheSame(oldItem: DemoModel, newItem: DemoModel) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: DemoModel, newItem: DemoModel) =
        oldItem.id == newItem.id
                && oldItem.visible == newItem.visible
                && oldItem.name == newItem.name
}

class DemoAdapter : ListAdapter<DemoModel, DemoAdapter.DemoViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DemoViewHolder {
        val binding =
            ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DemoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DemoViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class DemoViewHolder(private val binding: ListItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: DemoModel) {
            binding.apply {
                itemName.text = student.name + " " + student.visible
                if (student.visible) {
                    itemName.visibility = View.VISIBLE
                } else {
                    itemName.visibility = View.INVISIBLE
                }
            }
        }
    }
}


