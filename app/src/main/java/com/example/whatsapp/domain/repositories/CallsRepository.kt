package com.example.whatsapp.domain.repositories

import com.example.whatsapp.domain.models.calls.Communication
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CallsRepository {

    fun getCalls(): Flow<Resource<List<Communication>>>

}