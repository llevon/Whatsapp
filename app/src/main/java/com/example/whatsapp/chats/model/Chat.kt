package com.example.whatsapp.chats.model

import com.example.whatsapp.calls.model.Call
import java.util.UUID

data class Chat(
    val name: String,
    val profile: String,
    val lastMessage: String,
    val time: String,
    val uncheckedCount: Int,
    val id: String = UUID.randomUUID().toString()
)

val listOfChats = listOf(
    Chat(
        profile = "https://i.pinimg.com/736x/54/72/d1/5472d1b09d3d724228109d381d617326.jpg",
        name = "Levon",
        lastMessage = "no",
        uncheckedCount = 12,
        time = "12:35"
    ),
    Chat(
        profile = "https://media.sproutsocial.com/uploads/2022/06/profile-picture.jpeg",
        name = "Edgar",
        lastMessage = "no",
        uncheckedCount = 0,
        time = "14:55"

        ),
    Chat(
        profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
        name = "Narek",
        lastMessage = "aha",
        uncheckedCount = 12,
        time = "02:35"
    ),
)