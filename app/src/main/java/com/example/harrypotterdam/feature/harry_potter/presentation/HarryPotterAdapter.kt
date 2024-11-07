package com.example.harrypotterdam.feature.harry_potter.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.harrypotterdam.R
import androidx.recyclerview.widget.ListAdapter
import com.example.harrypotterdam.feature.harry_potter.domain.Characters

class HarryPotterAdapter:  ListAdapter<Characters, HarryPotterViewHolder>(HarryPotterDiffUtil()) {

    lateinit var onClick: (character: String) -> Unit

    fun setEvent(onClick: (String) -> Unit) {
        this.onClick = onClick
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarryPotterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_harrypotter_item, parent, false)
        return HarryPotterViewHolder(view)
    }

    override fun getItemCount(): Int = currentList.size

    override fun onBindViewHolder(holder: HarryPotterViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }
}

