package com.example.fragmentcontainerviewpractice

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 *  AFragment.kt
 *
 *  Created by Hayeong Lee on 2022/02/16
 *  Copyright © 2021 Shinhan Bank. All rights reserved.
 */

class AFragment(private val color: String) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when (color) {
            "A" -> {
                view.findViewById<TextView>(R.id.textView).apply {
                    text = "fragment A"
                    setBackgroundColor(Color.RED)
                }
            }
            "B" -> {
                view.findViewById<TextView>(R.id.textView).apply {
                    text = "fragment B"
                    setBackgroundColor(Color.GREEN)
                }
            }
        }
    }
}
