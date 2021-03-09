package com.example.jgandroidgroup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var activityLifeCycleBtn : Button
    lateinit var fragmentStackBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityLifeCycleBtn = findViewById(R.id.btn_task_1)
        fragmentStackBtn = findViewById(R.id.btn_task_2)

        // Links to the first task activity
        activityLifeCycleBtn.setOnClickListener {
            startActivity(Intent(this, FirstTask::class.java))
        }

        // Links to the second task activity
        fragmentStackBtn.setOnClickListener {
            startActivity(Intent(this, SecondTask::class.java))
        }
    }
}