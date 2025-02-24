package com.example.matulohka.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.matulohka.R
import com.example.matulohka.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)!!.findNavController()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            navMenuVisibility(destination.id)
        }

        setContentView(binding.root)
    }

    private fun navMenuVisibility(fragmentId: Int){
        when(fragmentId) {
            R.id.onboardFragment -> binding.bottomMenu.visibility = View.INVISIBLE
            R.id.homeFragment -> binding.bottomMenu.visibility = View.VISIBLE
        }
    }
}