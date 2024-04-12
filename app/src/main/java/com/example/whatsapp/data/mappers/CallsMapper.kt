package com.example.whatsapp.data.mappers

import com.example.whatsapp.domain.models.calls.Call
import com.example.whatsapp.domain.models.calls.CallDto
import com.example.whatsapp.domain.models.calls.Video
import com.example.whatsapp.domain.models.calls.VideoDto

fun CallDto.toCall() = Call(profile, name, lastCalled, id)

fun VideoDto.toVideo() = Video(profile, name, lastCalled, id)

fun List<CallDto>.toCalls() = map { it.toCall() }

fun List<VideoDto>.toVideos() = map { it.toVideo() }