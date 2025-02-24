package com.example.matulohka.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matulohka.R
import com.example.matulohka.data.model.GoodsModel
import com.example.matulohka.databinding.FragmentCatalogBinding
import com.example.matulohka.presentation.adapter.CategoryAdapter
import com.example.matulohka.presentation.adapter.GoodsGridAdapter
import com.example.matulohka.presentation.utils.GetGoods


class CatalogFragment : Fragment() {

    private lateinit var binding: FragmentCatalogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCatalogBinding.inflate(layoutInflater)

        binding.categoryRecyclerView.adapter = CategoryAdapter(arrayListOf(
            GoodsModel(category = "All"),
            GoodsModel(category = "Outdoor"),
            GoodsModel(category = "Tennis"),
            GoodsModel(category = "Running")
        ), context = context)

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.goodsRecyclerView.adapter = GoodsGridAdapter(GetGoods.getGoodsAs(GoodsModel(onBasket = false, favorite = true, bestSeller = true), 12), context = context)
        binding.goodsRecyclerView.layoutManager = GridLayoutManager(context, 2)

        return binding.root
    }


}