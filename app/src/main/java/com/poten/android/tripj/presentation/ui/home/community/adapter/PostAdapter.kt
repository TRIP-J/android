package com.poten.android.tripj.presentation.ui.home.community.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poten.android.tripj.data.model.Post
import com.poten.android.tripj.databinding.ItemPostBinding

// 게시글에 들어갈 item 을 위한 Adapter
class PostAdapter(
    private val onClick: () -> Unit,
) : ListAdapter<Post, PostAdapter.PostViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            with(binding) {
                userNameTextView.text = item.nickName
                postContentTextView.text = item.content
                postTitleTextView.text = item.title
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Post>() {
            override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
                return oldItem == newItem
            }

        }
    }
}