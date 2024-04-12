package com.example.whatsapp.chats

import androidx.recyclerview.widget.DiffUtil
import com.example.whatsapp.calls.model.Call
import com.example.whatsapp.chats.model.Chat

class DiffUtilCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}