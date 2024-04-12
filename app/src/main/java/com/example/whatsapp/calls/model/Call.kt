package com.example.whatsapp.calls.model

import java.util.UUID

data class Call(
    val profile: String,
    val name: String,
    val lastCalled: String,
    val id: String = UUID.randomUUID().toString()
): Communication

val listOfCalls = listOf(
    Call(
        profile = "https://i.pinimg.com/736x/54/72/d1/5472d1b09d3d724228109d381d617326.jpg",
        name = "Levon",
        lastCalled = "5 min ago",

    ),
    Call(
        profile = "https://media.sproutsocial.com/uploads/2022/06/profile-picture.jpeg",
        name = "Edgar",
        lastCalled = "1 hour ago",

    ),Call(
        profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
        name = "Narek",
        lastCalled = "2 days ago",
    ),
)

