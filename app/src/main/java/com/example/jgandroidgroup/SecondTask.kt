package com.example.jgandroidgroup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.text.DateFormat
import java.util.*

class SecondTask : AppCompatActivity() {
    lateinit var timeTextView : TextView
    lateinit var dateTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_task)

        timeTextView = findViewById(R.id.time_textView)
        dateTextView = findViewById(R.id.date_textView)

        //Get the current time and display it on the screen
        val myTime = DateFormat.getTimeInstance(DateFormat.MEDIUM)
        timeTextView.text = convertTime(myTime)

        // Get the current date and display it on the screen
        val myDate = DateFormat.getDateInstance(DateFormat.FULL)
        dateTextView.text = myDate.format(Date())

        // Change status bar background color for this activity
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this,R.color.second_background)
    }

    /**
     * This method takes an unformatted time variable
     * formats it and return a string with a '0' added to it if the hour is less than 10
     */
    private fun convertTime(s: DateFormat): String {
        val timeToString = s.format(Date().time).split(":")
        val hh = timeToString[0]
        var actualTime = ""
        if (hh.toInt() < 10){
            actualTime = "${0}${s.format(Date().time)}"
        }
        return actualTime
    }
}