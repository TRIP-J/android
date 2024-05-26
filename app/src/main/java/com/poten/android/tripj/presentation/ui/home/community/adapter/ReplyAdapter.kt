package com.poten.android.tripj.presentation.ui.home.community.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poten.android.tripj.data.model.Reply
import com.poten.android.tripj.databinding.ItemReplyBinding


class ReplyAdapter(

) : ListAdapter<Reply, ReplyAdapter.ReplyViewHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReplyViewHolder {
        return ReplyViewHolder(
            ItemReplyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReplyViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class ReplyViewHolder(private val binding: ItemReplyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Reply) {

        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Reply>() {
            override fun areItemsTheSame(oldItem: Reply, newItem: Reply): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Reply, newItem: Reply): Boolean {
                return oldItem == newItem
            }

        }
    }


}