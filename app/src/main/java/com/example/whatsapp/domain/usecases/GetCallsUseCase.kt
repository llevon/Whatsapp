package com.example.whatsapp.domain.usecases

import com.example.whatsapp.domain.models.calls.Communication
import com.example.whatsapp.domain.repositories.CallsRepository
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetCallsUseCase(
    private val callsRepository: CallsRepository
) {

    operator fun invoke(): Flow<Resource<List<Communication>>> {
        return callsRepository.getCalls()
    }

}