package com.example.whatsapp.di

import com.example.whatsapp.data.repositories.CallsRepositoryImpl
import com.example.whatsapp.data.repositories.ChatsRepositoryImpl
import com.example.whatsapp.domain.repositories.CallsRepository
import com.example.whatsapp.domain.repositories.ChatsRepository
import com.example.whatsapp.domain.usecases.GetCallsUseCase
import com.example.whatsapp.domain.usecases.GetChatsUseCase

object AppComponent {

    private val chatsRepository: ChatsRepository = ChatsRepositoryImpl()
    private val callsRepository: CallsRepository = CallsRepositoryImpl()
    val getChatsUseCase: GetChatsUseCase
        get() = GetChatsUseCase(chatsRepository)

    val getCallsUseCase: GetCallsUseCase
        get() = GetCallsUseCase(callsRepository)

}