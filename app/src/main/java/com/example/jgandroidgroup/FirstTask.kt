package com.example.jgandroidgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.week4first.DepthPageTransformer
import com.example.week4first.RecyclerViewAdapter
import com.example.week4first.Supplier
import com.example.week4first.ViewPagerAdapter
import me.relex.circleindicator.CircleIndicator3
import java.util.*

class FirstTask : AppCompatActivity() {
    private lateinit var viewPager : ViewPager2
    private lateinit var recyclerView : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_task)

        recyclerView = findViewById(R.id.twitter_feeds)
        viewPager = findViewById(R.id.view_pager)

        // Set a new adapter to provide child views of the recyclerView on demand
        recyclerView.adapter = RecyclerViewAdapter(Supplier.tweets)

        // Set the LayoutManager that this RecyclerView will use
        recyclerView.layoutManager = LinearLayoutManager(this).apply {
            orientation = LinearLayoutManager.VERTICAL
        }


        // Set a new adapter to provide child views of the viewPager on demand
        viewPager.adapter = ViewPagerAdapter(Supplier.times)

        // Sets the orientation of the ViewPager2
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator : CircleIndicator3 = findViewById(R.id.indicator)
        indicator.setViewPager(viewPager)

        //Sets whether this ViewGroup will clip its children to its padding and resize
        // (but not clip) any EdgeEffect to the padded region, if padding is present.
        viewPager.clipToPadding = false
        viewPager.clipChildren = false

        // Set the number of pages that should be retained to either side of the currently visible pages
        viewPager.offscreenPageLimit = 3


        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER


        // Animates the page current page to zoom out and the other two to zoom in
        val compositePageTransformer = CompositePageTransformer()
        val marginPageTransformer = MarginPageTransformer(40)
        compositePageTransformer.addTransformer(marginPageTransformer)
        compositePageTransformer.addTransformer(DepthPageTransformer())
        viewPager.setPageTransformer(compositePageTransformer)


        // Change status bar background color for this activity
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.purple_600)
    }
}