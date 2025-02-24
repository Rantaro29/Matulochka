package com.example.matulohka.data.model

import android.graphics.drawable.Drawable
import com.example.matulohka.R

data class GoodsModel(
    val id: Int = 1,
    val category: String = "Tennis",
    val onBasket: Boolean = false,
    val image: Int = R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_2,
    val title: String = "Nike Air Max",
    val description: String? = null,
    val bestSeller: Boolean = false,
    val price: String = "752.00",
    val favorite: Boolean = false
)
