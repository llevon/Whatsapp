package com.example.whatsapp.calls

import androidx.lifecycle.ViewModel
import com.example.whatsapp.calls.model.Communication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CallsViewModel:ViewModel(){
    private var _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> = _state.asStateFlow()



    data class State (
        val comms: List<Communication> = emptyList()
    )
}