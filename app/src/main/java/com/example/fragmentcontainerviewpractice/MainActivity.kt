package com.example.fragmentcontainerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.fragmentcontainerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setFragment()
    }

    private fun setFragment() {
        val aFragment = AFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(binding.fragmentContainer.id, aFragment)
            addToBackStack(null)
            commit()
        }
    }
}
