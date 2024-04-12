package com.example.whatsapp.domain.usecases

import com.example.whatsapp.domain.models.chat.Chat
import com.example.whatsapp.domain.repositories.ChatsRepository
import com.example.whatsapp.utils.Resource

class GetChatsUseCase(
    private val chatsRepository: ChatsRepository
) {

    suspend operator fun invoke(): Resource<List<Chat>> {
        return chatsRepository.getChats()
    }

}