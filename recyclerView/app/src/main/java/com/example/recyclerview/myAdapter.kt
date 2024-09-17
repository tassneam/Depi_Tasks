package com.example.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.FragmentItemBinding
import com.example.recyclerview.databinding.ItemLayoutBinding

class myAdapter(val list: List<User>, val onItemClick: (User) -> Unit) :
    RecyclerView.Adapter<myAdapter.myHolder>() {

    inner class myHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindData(user: User) {
            binding.user=User(user.name,user.phone,user.email)
            binding.root.setOnClickListener {
                onItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter.myHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myHolder(binding)
    }

    override fun onBindViewHolder(holder: myAdapter.myHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size


}