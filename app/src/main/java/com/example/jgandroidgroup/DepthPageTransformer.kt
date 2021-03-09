package com.example.week4first

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class DepthPageTransformer : ViewPager2.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val r = 1 - abs(position)
        view.scaleY = 0.85f + r * 0.15f
    }
}