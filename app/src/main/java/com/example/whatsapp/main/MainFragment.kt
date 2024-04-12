package com.example.whatsapp.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.whatsapp.databinding.FragmentChatsBinding
import com.example.whatsapp.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding ?: throw Exception("Binding is null")

    private val tabBarNames = arrayOf(
        "Chats",
        "Calls"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabBarNames[position]
        }.attach()
    }

    private fun setupViewPager(){
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}