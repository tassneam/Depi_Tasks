package com.example.dependencyinjectionretrofit
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinjectionretrofit.databinding.AlbumItemBinding

class AlbumAdapter(var albumList: MutableList<Album>):RecyclerView.Adapter<AlbumAdapter.AlbumHolder>() {
    inner class AlbumHolder(val binding: AlbumItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindData(album: Album){
            binding.album = album
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val binding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AlbumHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        holder.bindData(albumList[position])
    }
    override fun getItemCount()=albumList.size

    fun updateData(newList: List<Album>) {
        val diffCallback = AlbumDiffUtil(albumList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        albumList.clear()
        albumList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}