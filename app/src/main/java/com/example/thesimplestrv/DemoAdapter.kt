package com.example.thesimplestrv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thesimplestrv.databinding.ListItemLayoutBinding
import com.example.thesimplestrv.model.DemoModel
import com.example.thesimplestrv.nested.NestedAdapter

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

        private val innerAdapter = NestedAdapter()

        init {
            binding.itemNestedList.layoutManager =
                LinearLayoutManager(binding.itemNestedList.context, LinearLayoutManager.HORIZONTAL, false)
            binding.itemNestedList.adapter = innerAdapter
        }

        fun bind(student: DemoModel) {
            binding.apply {
                itemName.text = binding.itemName.resources.getString(R.string.item_name_template,
                    student.name,
                    student.visible)

                if (student.visible) {
                    itemName.visibility = View.VISIBLE
                } else {
                    itemName.visibility = View.INVISIBLE
                }

                innerAdapter.submitList(student.nestedThings)
            }
        }
    }
}


