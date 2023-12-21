package com.example.datastore.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datastore.data.model.PostResponse
import com.example.datastore.databinding.ItemGiphyBinding

class PostAdapter(private val postList: MutableList<PostResponse.Result> = mutableListOf() ): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding:ItemGiphyBinding): RecyclerView.ViewHolder(binding.root){
         fun bind(item: PostResponse.Result){
            binding.tvTitle.text  = item.title

         }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostViewHolder {
        val binding = ItemGiphyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}