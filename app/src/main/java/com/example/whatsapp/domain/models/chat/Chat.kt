package com.example.whatsapp.domain.models.chat

data class Chat(
    val name: String,
    val profile: String,
    val lastMessage: String,
    val time: String,
    val uncheckedCount: Int,
    val id: String
)