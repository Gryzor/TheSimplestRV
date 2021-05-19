package com.example.thesimplestrv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.thesimplestrv.databinding.FragmentFirstBinding
import java.time.LocalTime

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val viewModel: FirstFragmentViewModel by viewModels()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val adapter = DemoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        binding.deleteButton.setOnClickListener {
            viewModel.deleteData(viewModel.randomPosition())
        }

        binding.updateButton.setOnClickListener {
            viewModel.updateData(viewModel.randomPosition(), "Updated at ${LocalTime.now()} ")
        }

        viewModel.demoLiveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }
}