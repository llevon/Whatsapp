package com.example.whatsapp.calls.model

import java.util.UUID

data class Video(
    val profile: String,
    val name: String,
    val lastCalled: String,
    val id: String = UUID.randomUUID().toString()
): Communication
