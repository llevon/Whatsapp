package com.example.whatsapp.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.calls.model.listOfCalls
import com.example.whatsapp.chats.model.listOfChats
import com.example.whatsapp.databinding.FragmentCallsBinding
import com.example.whatsapp.databinding.FragmentChatsBinding

class ChatsFragment: Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
    get() = _binding ?: throw Exception("Binding is null")

    private val adapter = ChatListAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvChats.adapter = adapter
        binding.rvChats.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.submitList(listOfChats)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}