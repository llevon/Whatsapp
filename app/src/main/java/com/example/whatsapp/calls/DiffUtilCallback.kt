package com.example.whatsapp.calls

import androidx.recyclerview.widget.DiffUtil
import com.example.whatsapp.calls.model.Call

class DiffUtilCallback : DiffUtil.ItemCallback<Call>() {
    override fun areItemsTheSame(oldItem: Call, newItem: Call): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Call, newItem: Call): Boolean {
        return oldItem == newItem
    }
}