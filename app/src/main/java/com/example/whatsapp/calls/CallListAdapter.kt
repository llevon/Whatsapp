package com.example.whatsapp.calls

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapp.calls.model.Call
import com.example.whatsapp.calls.model.Video
import com.example.whatsapp.databinding.ItemCallBinding

class CallListAdapter: ListAdapter<Call,CallListAdapter.CallViewHolder>(DiffUtilCallback()) {

     class CallViewHolder(val binding: ItemCallBinding): RecyclerView.ViewHolder(binding.root) {
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

    class VideoViewHolder(val binding: ItemCallBinding): RecyclerView.ViewHolder(binding.root) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallViewHolder {
        val binding = ItemCallBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CallViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CallViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}