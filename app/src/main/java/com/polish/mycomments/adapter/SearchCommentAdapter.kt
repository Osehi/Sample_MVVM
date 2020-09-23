package com.polish.mycomments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.databinding.ListItemJpresponseBinding
import com.polish.mycomments.databinding.SearchListItemBinding
import com.polish.mycomments.model.jpbody.JPPostResponse
import com.polish.mycomments.model.jpsearch.JPSearchItem

class SearchCommentAdapter(val clickListener:OnClickListener): ListAdapter<JPSearchItem, SearchCommentAdapter.JPSearchViewHolder>(DiffCallback){

    class JPSearchViewHolder(var binding: SearchListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(jpSearchItem: JPSearchItem, clickListener: OnClickListener){

            binding.jpSearchItem = jpSearchItem

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<JPSearchItem>(){
        override fun areItemsTheSame(oldItem: JPSearchItem, newItem: JPSearchItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JPSearchItem, newItem: JPSearchItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JPSearchViewHolder {
        return JPSearchViewHolder(SearchListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: JPSearchViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(post)
        }

        holder.bind(post, clickListener)

    }

    class OnClickListener(val clickListener:(jpSearchItem: JPSearchItem) -> Unit){

        fun onClick(jpSearchItem: JPSearchItem) = clickListener(jpSearchItem)

    }


}