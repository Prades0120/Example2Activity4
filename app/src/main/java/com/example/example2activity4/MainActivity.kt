package com.example.example2activity4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val random = Random()
        var numRandom = random.nextInt(99)+1
        val buttonNewGame = findViewById<Button>(R.id.buttonNewGame)
        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        val textView = findViewById<TextView>(R.id.textView)

        buttonCheck.setOnClickListener {
            var num: Int? = null
            try {
                num = editText.text.toString().toInt()
            }catch (e: Exception) {}

            if (num != null) {
                when {
                    num<numRandom -> textView.text = "Your number is lower"
                    num>numRandom -> textView.text = "Your number is higher"
                    else -> textView.text = "YOU WIN"
                }
            }
            editText.setText("")
        }

        buttonNewGame.setOnClickListener {
            numRandom = random.nextInt(99)+1
            textView.setText(R.string.enter_a_number_between_1_and_100)
        }

    }
}