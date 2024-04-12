package com.example.whatsapp.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.calls.model.Call
import com.example.whatsapp.chats.model.Chat
import com.example.whatsapp.databinding.ItemCallBinding
import com.example.whatsapp.databinding.ItemChatBinding

class ChatListAdapter: ListAdapter<Chat, ChatListAdapter.ChatViewHolder>((DiffUtilCallback())) {

    class ChatViewHolder(val binding: ItemChatBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chat: Chat, isLast: Boolean) {
            binding.chatProfileName.text = chat.name
            binding.lastMessage.text = chat.lastMessage
            binding.time.text = chat.time
            binding.uncheckedMessages.text = chat.uncheckedCount.toString()
            binding.cvUnchecked.isVisible = chat.uncheckedCount != 0
            binding.divider.isVisible = isLast.not()
            Glide
                .with(binding.root)
                .load(chat.profile)
                .centerCrop()
                .into(binding.ivAvatar);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val binding = ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.bind(getItem(position), itemCount - 1 == position)
    }
}