package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity" // for logs
    private var clickCount = 0 // for count
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        Log.i(tag, "onCreate - экран создан")
        val textViewCount = findViewById<TextView>(R.id.textViewCount)
        val buttonClick = findViewById<Button>(R.id.buttonClick)

        buttonClick.setOnClickListener {
            Log.i(tag, "пользователь нажал на кнопку")
            clickCount++
            Log.d(tag, "счетчик изменен на $clickCount")
            textViewCount.text = "Нажатий: $clickCount"
        }
    }
}