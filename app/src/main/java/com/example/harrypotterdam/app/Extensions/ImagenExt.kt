package com.example.harrypotterdam.app.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide


fun ImageView.loadUrl(image: String) {
        Glide.with(this)
            .load(image)
            .into(this)
    }
