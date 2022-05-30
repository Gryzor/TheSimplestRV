package com.example.thesimplestrv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.thesimplestrv.databinding.FragmentFirstBinding
import com.example.thesimplestrv.listeners.ThingClickListener
import com.example.thesimplestrv.outer.StudentAdapter
import java.time.LocalTime

class FirstFragment : Fragment() {

    private val viewModel: FirstFragmentViewModel by viewModels()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val innerClickListener = ThingClickListener {
        viewModel.onNestedThingClicked(it.parentId, it)
    }

    private val adapter = StudentAdapter(innerClickListener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        binding.deleteButton.setOnClickListener {
            viewModel.deleteDataAtRandomPosition()
        }

        binding.updateButton.setOnClickListener {
            viewModel.updateDataAtRandomPosition("Updated at ${LocalTime.now()} ")
        }

        viewModel.studentsLiveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}