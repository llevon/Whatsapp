package com.example.whatsapp.presentation.calls.callsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.domain.models.calls.Call
import com.example.whatsapp.domain.models.calls.Communication
import com.example.whatsapp.domain.models.calls.Video
import com.example.whatsapp.databinding.ItemCallBinding
import com.example.whatsapp.databinding.ItemVideoBinding

class CallListAdapter: ListAdapter<Communication,RecyclerView.ViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CommunicationType.CALL.ordinal -> {
                val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                CallViewHolder(binding)
            }

            CommunicationType.VIDEO_CALL.ordinal -> {
                val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                VideoViewHolder(binding)
            }
            else -> {
                throw IllegalArgumentException("Undefined view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CallViewHolder -> holder.bind(getItem(position) as Call)
            is VideoViewHolder -> holder.bind(getItem(position) as Video)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Call -> CommunicationType.CALL.ordinal
            is Video -> CommunicationType.VIDEO_CALL.ordinal
        }
    }

    class CallViewHolder(private val binding: ItemCallBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(call: Call) {
            binding.callProfileName.text = call.name
            binding.lastCall.text = call.lastCalled
            Glide
                .with(binding.root)
                .load(call.profile)
                .centerCrop()
                .into(binding.ivAvatar);
        }
    }

    class VideoViewHolder(private val binding: ItemVideoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Video) {
            binding.callProfileName.text = video.name
            binding.lastCall.text = video.lastCalled
            Glide
                .with(binding.root)
                .load(video.profile)
                .centerCrop()
                .into(binding.ivAvatar);
        }
    }

    enum class CommunicationType {
        CALL, VIDEO_CALL
    }

}