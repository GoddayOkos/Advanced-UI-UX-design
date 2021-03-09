package com.example.week4first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jgandroidgroup.R


class ViewPagerAdapter (val times : List<Time>) :
    RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {


    inner class ViewPagerViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val numberOfDays : TextView = itemView.findViewById(R.id.numberOfDays)
        val numberOfHours : TextView = itemView.findViewById(R.id.numberOfHours)
        val numberOfMinutes : TextView = itemView.findViewById(R.id.numberOfMinutes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pager_view_holder,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val time = times[position]
        holder.numberOfDays.text = time.days
        holder.numberOfHours.text = time.hours
        holder.numberOfMinutes.text = time.minutes
    }

    override fun getItemCount(): Int {
        return times.size
    }
}