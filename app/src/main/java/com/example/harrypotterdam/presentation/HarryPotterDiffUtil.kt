package com.example.harrypotterdam.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.harrypotterdam.domain.Characters

class HarryPotterDiffUtil: DiffUtil.ItemCallback<Characters>() {
    override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
        return oldItem == newItem
    }
}