package com.example.datastore.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datastore.data.model.EmojiResponse
import com.example.datastore.databinding.ItemGiphyBinding

class GiphyAdapter(private val emojiList: MutableList<EmojiResponse.Data> = mutableListOf() ): RecyclerView.Adapter<GiphyAdapter.GiphyViewHolder>() {

    inner class GiphyViewHolder(val binding:ItemGiphyBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(item:EmojiResponse.Data){
                binding.tvTitle.text = item.title
                Glide.with(binding.ivImage).load(item.images).into(binding.ivImage)
            }

    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GiphyAdapter.GiphyViewHolder {
        val binding = ItemGiphyBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GiphyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GiphyAdapter.GiphyViewHolder, position: Int) {
        val emoji = emojiList[position]
        holder.bind(emoji)

    }

    override fun getItemCount(): Int {
        return emojiList.size
    }


}