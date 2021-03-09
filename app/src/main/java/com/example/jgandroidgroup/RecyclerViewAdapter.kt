package com.example.week4first

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.jgandroidgroup.R


class RecyclerViewAdapter (val tweets : List<Tweet>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val twitter_feeds : TextView = itemView.findViewById(R.id.twitter_feeds_holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_holder,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val tweet_feed = tweets[position]
        holder.twitter_feeds.text = tweet_feed.tweet
    }

    override fun getItemCount(): Int {
        return tweets.size
    }
}