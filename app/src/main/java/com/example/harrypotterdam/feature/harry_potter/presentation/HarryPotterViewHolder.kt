package com.example.harrypotterdam.feature.harry_potter.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.harrypotterdam.app.Extensions.loadUrl
import com.example.harrypotterdam.databinding.ViewHarrypotterItemBinding
import com.example.harrypotterdam.feature.harry_potter.domain.Characters

class HarryPotterViewHolder(val view : View) : RecyclerView.ViewHolder(view) {


        private lateinit var binding: ViewHarrypotterItemBinding

        fun bind(model: Characters, onClick: (String) -> Unit) {
            binding = ViewHarrypotterItemBinding.bind(view)

            binding.apply {
                model.image?.let { image.loadUrl(it) }
                name.text = model.name
                house.text = model.house
            }
            view.setOnClickListener {
                onClick.invoke(model.id)
            }
        }
}