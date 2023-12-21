package com.example.datastore.ui.networking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datastore.databinding.ItemGiphyBinding
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.networking.PokemonResponse

class PokemonAdapter(private val pokemonList: ArrayList<PokemonResponse.Results>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(private val binding: ItemGiphyBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: PokemonResponse.Results) {
            binding.tvTitle.text = pokemon.name
        }
    }

    fun addAll(newPokemonList: List<PokemonResponse.Results>) {
        pokemonList.clear()
        pokemonList.addAll(newPokemonList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonAdapter.PokemonViewHolder {
        val binding = ItemGiphyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

}
