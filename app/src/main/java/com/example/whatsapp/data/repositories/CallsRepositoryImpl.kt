package com.example.whatsapp.data.repositories

import com.example.whatsapp.data.mappers.toCalls
import com.example.whatsapp.data.mappers.toVideos
import com.example.whatsapp.domain.models.calls.CallDto
import com.example.whatsapp.domain.models.calls.Communication
import com.example.whatsapp.domain.models.calls.VideoDto
import com.example.whatsapp.domain.repositories.CallsRepository
import com.example.whatsapp.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CallsRepositoryImpl : CallsRepository {

    private val listOfVideoCalls = listOf(
        VideoDto(
            profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
            name = "Narek",
            lastCalled = "2 days ago",
        ),
        VideoDto(
            profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
            name = "Eduard",
            lastCalled = "5 days ago",
        ),
        VideoDto(
            profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
            name = "Gor",
            lastCalled = "3 days ago",
        ),
    )

    private val listOfCalls = listOf(
        CallDto(
            profile = "https://i.pinimg.com/736x/54/72/d1/5472d1b09d3d724228109d381d617326.jpg",
            name = "Levon",
            lastCalled = "5 min ago",

        ),
        CallDto(
            profile = "https://media.sproutsocial.com/uploads/2022/06/profile-picture.jpeg",
            name = "Edgar",
            lastCalled = "1 hour ago",

        ),
        CallDto(
            profile = "https://static.vecteezy.com/system/resources/thumbnails/009/209/212/small/neon-glowing-profile-icon-3d-illustration-vector.jpg",
            name = "Narek",
            lastCalled = "2 days ago",
        ),
    )

    override fun getCalls(): Flow<Resource<List<Communication>>> {
        return flow {
            delay(2000L)
            val calls = listOfCalls.toCalls()
            val videos = listOfVideoCalls.toVideos()
            val communications = mutableListOf<Communication>().apply {
                addAll(calls)
                addAll(videos)
                shuffle()
            }.toList()
            emit(Resource.Success(communications))
        }
    }

}