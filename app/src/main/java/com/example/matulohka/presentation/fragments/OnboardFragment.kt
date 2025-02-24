package com.example.matulohka.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.matulohka.R
import com.example.matulohka.databinding.FragmentOnboardBinding
import com.example.matulohka.presentation.adapter.OnboardViewPagerAdapter


class OnboardFragment : Fragment() {

    private lateinit var binding: FragmentOnboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOnboardBinding.inflate(layoutInflater)

        binding.viewPager.adapter = OnboardViewPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when(position) {
                    0 -> binding.button.text = getString(R.string.start)
                    1 -> binding.button.text = getString(R.string.next)
                    2 -> binding.button.text = getString(R.string.next)
                }
            }
        })

        binding.button.setOnClickListener {
            if(binding.viewPager.currentItem == 2) {
                findNavController().navigate(R.id.action_onboardFragment_to_homeFragment)
            } else {
                binding.viewPager.currentItem += 1
            }
        }

        return binding.root
    }


}