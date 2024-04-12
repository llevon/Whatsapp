package com.example.whatsapp.domain.models.calls

data class Call(
    val profile: String,
    val name: String,
    val lastCalled: String,
    override val id: String
): Communication

