package com.polish.mycomments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.databinding.PostListItemBinding

import com.polish.mycomments.model.POSTItem

class HomePageAdapter(val clickListener:OnClickListener): ListAdapter<POSTItem, HomePageAdapter.POSTViewHolder>(DiffCallback){

    class POSTViewHolder(var binding: PostListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(postItem:POSTItem, clickListener: OnClickListener){

            binding.postItem = postItem

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<POSTItem>(){
        override fun areItemsTheSame(oldItem: POSTItem, newItem: POSTItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: POSTItem, newItem: POSTItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): POSTViewHolder {
        return POSTViewHolder(PostListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: POSTViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(post)
        }

        holder.bind(post, clickListener)

    }

    class OnClickListener(val clickListener:(postItem:POSTItem) -> Unit){

        fun onClick(postItem: POSTItem) = clickListener(postItem)

    }


}