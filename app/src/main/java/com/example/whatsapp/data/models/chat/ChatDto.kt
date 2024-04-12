package com.example.whatsapp.data.models.chat

import java.util.UUID

data class ChatDto(
    val name: String,
    val profile: String,
    val lastMessage: String,
    val time: String,
    val uncheckedCount: Int,
    val id: String = UUID.randomUUID().toString()
)