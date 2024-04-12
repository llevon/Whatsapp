package com.example.whatsapp.domain.models.calls

import java.util.UUID

data class CallDto(
    val profile: String,
    val name: String,
    val lastCalled: String,
    val id: String = UUID.randomUUID().toString()
)

