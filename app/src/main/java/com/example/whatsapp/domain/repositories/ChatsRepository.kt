package com.example.whatsapp.domain.repositories

import com.example.whatsapp.domain.models.chat.Chat
import com.example.whatsapp.utils.Resource

interface ChatsRepository {

    suspend fun getChats(): Resource<List<Chat>>

}