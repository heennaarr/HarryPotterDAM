package com.example.harrypotterdam.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.databinding.ViewHarrypotterItemBinding
import com.example.harrypotterdam.domain.Characters

class HarryPotterViewHolder(val view : View) : RecyclerView.ViewHolder(view) {


        private lateinit var binding: ViewHarrypotterItemBinding

        fun bind(model: Characters, onClick: (String) -> Unit) {
            binding = ViewHarrypotterItemBinding.bind(view)

            binding.apply {
                image.loadUrl(model.image)
                name.text = model.name
                house.text = model.house
            }
            view.setOnClickListener {
                onClick.invoke(model.id)
            }
        }
}