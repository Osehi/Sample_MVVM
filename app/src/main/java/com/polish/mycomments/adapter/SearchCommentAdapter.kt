package com.polish.mycomments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.databinding.ListItemJpresponseBinding
import com.polish.mycomments.databinding.SearchListItemBinding
import com.polish.mycomments.model.jpbody.JPPostResponse
import com.polish.mycomments.model.jpcomments.JPostCommentItem
import com.polish.mycomments.model.jpsearch.JPSearchItem

class SearchCommentAdapter(val clickListener:OnClickListener): ListAdapter<JPostCommentItem, SearchCommentAdapter.JPSearchViewHolder>(DiffCallback){

    class JPSearchViewHolder(var binding: SearchListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(jPostCommentItem: JPostCommentItem, clickListener: OnClickListener){

            binding.jPostCommentITem = jPostCommentItem

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<JPostCommentItem>(){
        override fun areItemsTheSame(oldItem: JPostCommentItem, newItem: JPostCommentItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem:JPostCommentItem, newItem: JPostCommentItem): Boolean {
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

    class OnClickListener(val clickListener:(jpostCommentItem: JPostCommentItem) -> Unit){

        fun onClick(jpostCommentItem: JPostCommentItem) = clickListener(jpostCommentItem)

    }


}