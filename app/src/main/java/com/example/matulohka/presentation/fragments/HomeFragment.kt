package com.example.matulohka.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matulohka.R
import com.example.matulohka.data.model.GoodsModel
import com.example.matulohka.databinding.FragmentHomeBinding
import com.example.matulohka.databinding.FragmentOnboardBinding
import com.example.matulohka.presentation.adapter.CategoryAdapter
import com.example.matulohka.presentation.adapter.GoodsAdapter
import com.example.matulohka.presentation.utils.GetGoods

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.categoryRecyclerView.adapter = CategoryAdapter(arrayListOf(
            GoodsModel(category = "All"),
            GoodsModel(category = "Outdoor"),
            GoodsModel(category = "Tennis"),
            GoodsModel(category = "Running")
        ), context = context)

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.seeAllPopular.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_popularFragment)
        }

        binding.popularGoodsRecyclerView.adapter = GoodsAdapter(arrayListOf(
            GoodsModel(bestSeller = true, onBasket = false, favorite = true),
            GoodsModel(bestSeller = true, onBasket = true),
            GoodsModel(bestSeller = true, onBasket = true),
        ), context = context)

        binding.popularGoodsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return binding.root
    }

}