package com.example.whatsapp.presentation.chats.chatsadapter

import androidx.recyclerview.widget.DiffUtil
import com.example.whatsapp.domain.models.chat.Chat

class DiffUtilCallback : DiffUtil.ItemCallback<Chat>() {
    override fun areItemsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Chat, newItem: Chat): Boolean {
        return oldItem == newItem
    }
}