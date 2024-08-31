package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        display = findViewById(R.id.calctext)

        val buttonClear: Button = findViewById(R.id.button)
        buttonClear.setOnClickListener { clearDisplay() }

        val buttonIds = listOf(R.id.button11, R.id.button12, R.id.button13, R.id.button7, R.id.button8, R.id.button9, R.id.button4,  R.id.button5, R.id.button19, R.id.button17, R.id.button2, R.id.button3, R.id.button10, R.id.button14, R.id.button15)

        for (id in buttonIds) {
            findViewById<Button>(id).setOnClickListener{appendToDisplay((it as Button).text.toString())}
        }

    }

    private fun clearDisplay() {
        display.text = ""
    }

    private fun appendToDisplay(value: String) {
        display.text = display.text.toString() + value
    }

}