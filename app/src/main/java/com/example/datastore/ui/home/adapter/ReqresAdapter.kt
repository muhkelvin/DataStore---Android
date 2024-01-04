package com.example.datastore.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.datastore.data.model.ReqresResponse
import com.example.datastore.databinding.ItemGiphyBinding
import com.example.datastore.databinding.ItemReqresBinding

class ReqresAdapter(private val dataList: MutableList<ReqresResponse.Result> = mutableListOf()) : RecyclerView.Adapter<ReqresAdapter.ReqresViewHolder>() {

    inner class ReqresViewHolder(private val binding: ItemGiphyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ReqresResponse.Result) {
            // Hanya mengambil title dan menampilkannya pada TextView dengan menggunakan View Binding
            binding.tvTitle.text = data.email
        }
    }

    // Perbarui nama kelas agar sesuai dengan konvensi ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReqresViewHolder {
        val binding = ItemGiphyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReqresViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ReqresViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    // Ganti fungsi addAll agar lebih efisien dengan menggunakan notifyItemRangeInserted
    fun addAll(newReqresList: List<ReqresResponse.Result>) {
        dataList.clear()
        dataList.addAll(newReqresList)
        notifyDataSetChanged()
    }
}
