package com.example.whatsapp.data.repositories

import com.example.whatsapp.data.mappers.toChats
import com.example.whatsapp.data.models.chat.ChatDto
import com.example.whatsapp.domain.models.chat.Chat
import com.example.whatsapp.domain.repositories.ChatsRepository
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.delay

class ChatsRepositoryImpl : ChatsRepository {

    private val listOfChats = listOf(
        ChatDto(
            profile = "https://i.pinimg.com/736x/54/72/d1/5472d1b09d3d724228109d381d617326.jpg",
            name = "Levon",
            lastMessage = "no",
            uncheckedCount = 12,
            time = "12:35"
        ),
        ChatDto(
            profile = "https://media.sproutsocial.com/uploads/2022/06/profile-picture.jpeg",
            name = "Edgar",
            lastMessage = "no",
            uncheckedCount = 0,
            time = "14:55"

            ),
        ChatDto(
            profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
            name = "Narek",
            lastMessage = "aha",
            uncheckedCount = 12,
            time = "02:35"
        ),
    )


    override suspend fun getChats(): Resource<List<Chat>> {
        delay(2000L)
        return Resource.Success(listOfChats.toChats())
    }

}