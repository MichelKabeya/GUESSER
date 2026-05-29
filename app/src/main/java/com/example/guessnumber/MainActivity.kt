package com.example.guessnumber

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // random number between 1 and 100
    private val randomNumber = (1..100).random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //VARIABLE DECLARATIONS
        val guess = findViewById<EditText>(R.id.userInput)
        val guessBtn = findViewById<Button>(R.id.guessBtn)
        val textResult = findViewById<TextView>(R.id.textResult)

        //BUTTON CLICK LISTENER
        guessBtn.setOnClickListener {
            val userGuess = guess.text.toString().toInt()
            if (userGuess == randomNumber) {
                textResult.setTextColor("#04FA0F".toColorInt())
                textResult.text = "Congratulations! You guessed the number."
            } else if (userGuess < randomNumber) {
                textResult.text = "The number is higher."
            } else {
                textResult.text = "The number is lower."
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}