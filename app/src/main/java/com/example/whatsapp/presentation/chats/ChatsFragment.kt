package com.example.whatsapp.presentation.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.whatsapp.databinding.FragmentChatsBinding
import com.example.whatsapp.presentation.chats.chatsadapter.ChatListAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ChatsFragment: Fragment() {
    private var _binding: FragmentChatsBinding? = null
    private val binding: FragmentChatsBinding
    get() = _binding ?: throw Exception("Binding is null")

    private val adapter = ChatListAdapter()
    private val viewModel: ChatsViewModel by viewModels { ChatsViewModelFactory() }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentChatsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        collectState()
        viewModel.getChats()
    }

    private fun setupRecyclerView() = with(binding) {
        rvChats.adapter = adapter
        rvChats.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun collectState() {
        viewModel.state
            .onEach {
                adapter.submitList(it.chats)
            }
            .launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}