package com.example.harrypotterdam.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.databinding.ViewHarrypotterItemBinding
import com.example.harrypotterdam.domain.Characters

class HarryPotterViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    private lateinit var binding : ViewHarrypotterItemBinding

    fun bind(character: Characters){
        binding  = ViewHarrypotterItemBinding.bind(view)

        binding.apply {
            name.text = character.name
            house.text = character.house
            image.loadUrl(character.image)
        }
    }
}