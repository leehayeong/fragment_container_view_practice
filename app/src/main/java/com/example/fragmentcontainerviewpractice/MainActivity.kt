package com.example.fragmentcontainerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fragmentcontainerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentFragment = "A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.title.setOnClickListener {
            changeFragment()
        }
    }

    private fun changeFragment() {
        val transaction = supportFragmentManager.beginTransaction()

        // fragment change animation: sliding
        // in: <-
        // out: ->
        when (currentFragment) {
            "A" -> {
                transaction
                    .setCustomAnimations(
                        R.anim.slide_in_right, R.anim.slide_out_left,
                        R.anim.slide_in_left, R.anim.slide_out_right
                    )
                    .add(binding.fragmentContainer.id, AFragment("B"))
                    .addToBackStack(null)
                    .commit()
                currentFragment = "B"
            }
            "B" -> {
                transaction
                    .setCustomAnimations(
                        R.anim.slide_in_right, R.anim.slide_out_left,
                        R.anim.slide_in_left, R.anim.slide_out_right
                    )
                    .add(binding.fragmentContainer.id, AFragment("A"))
                    .addToBackStack(null)
                    .commit()
                currentFragment = "A"
            }
        }
    }
}
