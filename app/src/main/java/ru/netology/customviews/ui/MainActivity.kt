package ru.netology.customviews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.customviews.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<StatsView>(R.id.stats).data = listOf(
            500F,
            500F,
            500F,
            500F,
        )
    }
}