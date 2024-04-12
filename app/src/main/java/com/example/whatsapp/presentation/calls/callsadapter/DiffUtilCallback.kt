package com.example.whatsapp.presentation.calls.callsadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.whatsapp.domain.models.calls.Communication

class DiffUtilCallback : DiffUtil.ItemCallback<Communication>() {
    override fun areItemsTheSame(oldItem: Communication, newItem: Communication): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Communication, newItem: Communication): Boolean {
        return oldItem == newItem
    }
}