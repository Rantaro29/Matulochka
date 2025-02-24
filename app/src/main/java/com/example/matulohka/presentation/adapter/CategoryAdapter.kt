package com.example.matulohka.presentation.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.matulohka.R
import com.example.matulohka.data.model.GoodsModel
import com.example.matulohka.databinding.FragmentCategoryItemBinding


class CategoryAdapter(private val values: List<GoodsModel>, private val context: Context?)
    : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCategoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.title.text = item.category

        holder.background.setOnClickListener {
            holder.background.background = ContextCompat.getDrawable(context!!, R.drawable.accent_r8)
            holder.title.setTextColor(ContextCompat.getColor(context, R.color.background))

            if(holder.background.findNavController().currentDestination!!.id == R.id.homeFragment) {
                holder.background.findNavController().navigate(R.id.catalogFragment)
            }

        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
        val background: ConstraintLayout = binding.background

    }

}