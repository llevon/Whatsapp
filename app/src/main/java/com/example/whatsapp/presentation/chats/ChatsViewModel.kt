package com.example.whatsapp.presentation.chats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsapp.domain.models.chat.Chat
import com.example.whatsapp.domain.usecases.GetChatsUseCase
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatsViewModel(
    private val getChatsUseCase: GetChatsUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun getChats() = viewModelScope.launch(Dispatchers.IO) {
        val resource = getChatsUseCase()
        withContext(Dispatchers.Main) {
            when (resource) {
                is Resource.Error -> Unit
                Resource.Loading -> Unit
                is Resource.Success -> _state.update { it.copy(chats = resource.model) }
            }
        }
    }

    data class State(
        val chats: List<Chat> = emptyList()
    )

}