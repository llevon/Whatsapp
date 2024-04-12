package com.example.whatsapp.presentation.chats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.whatsapp.di.AppComponent

class ChatsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return if (modelClass.isAssignableFrom(ChatsViewModel::class.java)) {
            ChatsViewModel(
                getChatsUseCase = AppComponent.getChatsUseCase
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}