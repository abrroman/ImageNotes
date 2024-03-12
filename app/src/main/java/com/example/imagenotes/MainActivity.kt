package com.example.imagenotes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.core.view.WindowInsetsControllerCompat
import com.example.imagenotes.ui.screens.mainScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.parseColor("#FF740F")
            window.navigationBarColor = Color.parseColor("#F0F0F0")
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = true

            mainScreen()
        }
    }
}