package com.example.datastore.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.datastore.R
import com.example.datastore.data.network.TMDB.TMDBRetrofitBuilder
import com.example.datastore.databinding.ItemGiphyBinding
import com.example.datastore.ui.home.TmdbDetailActivity
import rizkyfadilah.binar.synrgy6.android.learning.learningchapter5.tmdb.data.model.MovieResponse

class TMDAdapter() : RecyclerView.Adapter<TMDAdapter.TmdbViewHolder>() {

    private val dataList: MutableList<MovieResponse.Results> = mutableListOf()

    fun addAll(tmdbList: List<MovieResponse.Results>) {
        dataList.clear()
        dataList.addAll(tmdbList)
        notifyDataSetChanged()
    }

    inner class TmdbViewHolder(private val binding: ItemGiphyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MovieResponse.Results) {

            val baseUrlImg = TMDBRetrofitBuilder.BASE_URL_IMG
            val posterPath = data.posterPath
            val imgUrl = baseUrlImg + posterPath

            binding.tvTitle.text = data.title
            Glide.with(binding.ivImage)
                .load(imgUrl)
                .placeholder(R.drawable.place)
                .into(binding.ivImage)

            // Jika item di klik, kirimkan data movie ke listener
            itemView.setOnClickListener {
                // Mengatur intent untuk membuka aktivitas detail
                val intent = Intent(itemView.context, TmdbDetailActivity::class.java)
                intent.putExtra("movieId", data.id)

                // Mulai aktivitas detail
                itemView.context.startActivity(intent)

                // Menampilkan Toast bahwa data berhasil dikirim
                Toast.makeText(itemView.context, "Data berhasil dikirim: ${data.title}", Toast.LENGTH_SHORT).show()
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TMDAdapter.TmdbViewHolder {
        val binding = ItemGiphyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TmdbViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TMDAdapter.TmdbViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}



