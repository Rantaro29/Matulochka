package com.example.matulohka.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.matulohka.presentation.fragments.onboard.FirstOnboardFragment
import com.example.matulohka.presentation.fragments.onboard.SecondOnboardFragment
import com.example.matulohka.presentation.fragments.onboard.ThirdOnboardFragment

class OnboardViewPagerAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FirstOnboardFragment()
            1 -> SecondOnboardFragment()
            2 -> ThirdOnboardFragment()

            else -> FirstOnboardFragment()
        }
    }
}