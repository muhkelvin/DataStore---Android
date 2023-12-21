package com.example.datastore.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datastore.databinding.ItemGiphyBinding
import com.example.datastore.databinding.ItemGiphyLoadingBinding
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.giphy.util.LoadingResultHandler
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse

class TMDBAdapter(private val list: MutableList<LoadingResultHandler<MovieResponse.Results>> = mutableListOf()) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateView(list: List<LoadingResultHandler<MovieResponse.Results>>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun updateLoading(list: List<LoadingResultHandler.Loading<MovieResponse.Results>>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    inner class TMDBViewHolder(val binding: ItemGiphyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieResponse.Results) {
            binding.tvTitle.text = item.title
            Glide.with(binding.ivImage).load(item.posterPath).into(binding.ivImage)
        }
    }

    inner class LoadingTMDBViewHolder(val binding: ItemGiphyLoadingBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.pbLoading.progress = 0
            binding.tvTitle.text = "Loading..."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> LoadingTMDBViewHolder(
                ItemGiphyLoadingBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            1 -> TMDBViewHolder(
                ItemGiphyBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw RuntimeException("No View...")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = list[position].data
        when (holder) {
            is TMDBViewHolder -> {
                data?.let {
                    holder.bind(data)
                }
            }

            is LoadingTMDBViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position]) {
            is LoadingResultHandler.Loading -> 0
            is LoadingResultHandler.Content -> 1
            else -> throw RuntimeException("No View...")
        }
    }
}
