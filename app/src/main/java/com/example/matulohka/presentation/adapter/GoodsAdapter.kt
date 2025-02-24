package com.example.matulohka.presentation.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController

import com.example.matulohka.R
import com.example.matulohka.data.model.GoodsModel
import com.example.matulohka.databinding.FragmentGoodsItemBinding
import com.squareup.picasso.Picasso

class GoodsAdapter(
    private val values: List<GoodsModel>, private val context: Context?
) : RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentGoodsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.title
        Picasso.get().load(R.drawable.nike_zoom_winflo_3_831561_001_mens_running_shoes_11550187236tiyyje6l87_prev_ui_2).into(holder.image)

        if(item.bestSeller) {
            holder.bestSeller.visibility = View.VISIBLE
        } else {
            holder.bestSeller.visibility = View.INVISIBLE
        }

        if(item.favorite) {
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.favorite_fill))
        } else {
            holder.favorite.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.favorite))
        }

        if (item.onBasket){
            holder.button.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.cart_ic))
        } else {
            holder.button.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.icon_plus))
        }

        holder.price.text = "₽" + item.price

        holder.button.setOnClickListener {
            holder.button.findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment2)
        }

    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentGoodsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
        val image: ImageView = binding.imageGoods
        val bestSeller: TextView = binding.bestSeller
        val button: ImageButton = binding.buttonCart
        val favorite: ImageView = binding.favoriteImage
        val price: TextView = binding.price
    }

}