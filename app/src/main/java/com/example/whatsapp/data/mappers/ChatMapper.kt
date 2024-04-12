package com.example.whatsapp.data.mappers

import com.example.whatsapp.data.models.chat.ChatDto
import com.example.whatsapp.domain.models.chat.Chat

fun ChatDto.toChat() = Chat(name, profile, lastMessage, time, uncheckedCount, id)

fun List<ChatDto>.toChats() = map { it.toChat() }