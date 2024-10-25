package com.example.harrypotterdam.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterdam.R
import com.example.harrypotterdam.domain.Characters

class HarryPotterAdapter: RecyclerView.Adapter<HarryPotterViewHolder>() {
    private val dataList : MutableList<Characters> = mutableListOf()
    fun setData(characters: List<Characters>){
        dataList.clear()
        addData(characters)
    }
    fun addData(characters: List<Characters>){
        dataList.addAll(characters)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryPotterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_harrypotter_item, parent, false)
        return HarryPotterViewHolder(view)
    }
    override fun getItemCount(): Int = dataList.size
    override fun onBindViewHolder(holder: HarryPotterViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}