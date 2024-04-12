package com.example.whatsapp.presentation.calls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsapp.domain.models.calls.Communication
import com.example.whatsapp.domain.usecases.GetCallsUseCase
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class CallsViewModel(
    private val getCallsUseCase: GetCallsUseCase
) : ViewModel() {

    private var _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()

    fun getCalls() {
        getCallsUseCase()
            .flowOn(Dispatchers.IO)
            .onEach { resource ->
                when (resource) {
                    is Resource.Error -> Unit
                    Resource.Loading -> Unit
                    is Resource.Success -> _state.update { it.copy(calls = resource.model) }
                }
            }
            .flowOn(Dispatchers.Main)
            .launchIn(viewModelScope)
    }

    data class State(
        val calls: List<Communication> = emptyList()
    )
}