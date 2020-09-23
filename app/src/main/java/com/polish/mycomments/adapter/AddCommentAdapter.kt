package com.polish.mycomments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.polish.mycomments.databinding.ListItemJpresponseBinding
import com.polish.mycomments.databinding.PostListItemBinding
import com.polish.mycomments.model.POSTItem
import com.polish.mycomments.model.jpbody.JPPostResponse


class AddCommentAdapter(val clickListener:OnClickListener): ListAdapter<JPPostResponse, AddCommentAdapter.JPPOSTViewHolder>(DiffCallback){

    class JPPOSTViewHolder(var binding: ListItemJpresponseBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(jpPostResponse: JPPostResponse, clickListener: OnClickListener){

            binding.jpPostResposne = jpPostResponse

            binding.executePendingBindings()

        }

    }

    companion object DiffCallback: DiffUtil.ItemCallback<JPPostResponse>(){
        override fun areItemsTheSame(oldItem: JPPostResponse, newItem: JPPostResponse): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: JPPostResponse, newItem: JPPostResponse): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JPPOSTViewHolder {
        return JPPOSTViewHolder(ListItemJpresponseBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: JPPOSTViewHolder, position: Int) {
        val post = getItem(position)
        holder.itemView.setOnClickListener {
            clickListener.onClick(post)
        }

        holder.bind(post, clickListener)

    }

    class OnClickListener(val clickListener:(jpPostResponse: JPPostResponse) -> Unit){

        fun onClick(jpPostResponse: JPPostResponse) = clickListener(jpPostResponse)

    }


}