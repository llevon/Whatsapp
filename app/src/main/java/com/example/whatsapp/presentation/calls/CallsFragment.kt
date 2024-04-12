package com.example.whatsapp.presentation.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.databinding.FragmentCallsBinding
import com.example.whatsapp.presentation.calls.callsadapter.CallListAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CallsFragment: Fragment() {
    private var _binding: FragmentCallsBinding? = null
    private val binding: FragmentCallsBinding
        get() = _binding ?: throw Exception("Binding is null")

    private val adapter = CallListAdapter()
    private val viewModel: CallsViewModel by viewModels { CallsViewModelFactory() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCallsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        collectState()
        viewModel.getCalls()
    }

    private fun setupRecyclerView() = with(binding) {
        rvCalls.adapter = adapter
        rvCalls.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun collectState() {
        viewModel.state
            .onEach {
                adapter.submitList(it.calls)
            }
            .launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}