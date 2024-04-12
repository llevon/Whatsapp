package com.example.whatsapp.presentation.calls

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.whatsapp.di.AppComponent

class CallsViewModelFactory : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return if (modelClass.isAssignableFrom(CallsViewModel::class.java)) {
            CallsViewModel(
                getCallsUseCase = AppComponent.getCallsUseCase
            ) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}