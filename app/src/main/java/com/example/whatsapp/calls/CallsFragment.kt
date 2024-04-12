package com.example.whatsapp.calls

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.calls.model.listOfCalls
import com.example.whatsapp.databinding.FragmentCallsBinding

class CallsFragment: Fragment() {
    private var _binding: FragmentCallsBinding? = null
    private val binding: FragmentCallsBinding
        get() = _binding ?: throw Exception("Binding is null")

    private val adapter = CallListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCallsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvCalls.adapter = adapter
        binding.rvCalls.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.submitList(listOfCalls)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}