package com.example.datastore.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datastore.data.model.PokemonResponse
import com.example.datastore.databinding.ItemGiphyBinding


class PokemonAdapter(private val dataList: MutableList<PokemonResponse.Results> = mutableListOf()) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemGiphyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonResponse.Results) {
            // Hanya mengambil title dan menampilkannya pada TextView dengan menggunakan View Binding
            binding.tvTitle.text = data.name
        }
    }

    fun addAll(newPokemonList: List<PokemonResponse.Results>) {
        dataList.clear()
        dataList.addAll(newPokemonList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemGiphyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

