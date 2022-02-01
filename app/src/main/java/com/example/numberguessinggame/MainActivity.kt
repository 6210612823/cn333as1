package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var editText: EditText
    lateinit var Reset: Button
    lateinit var Confirm: Button

    var random: Int = nextInt(1, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        textView2 = findViewById(R.id.textView2)
        editText = findViewById(R.id.editText)
        Reset = findViewById(R.id.Reset)
        Confirm = findViewById(R.id.Confirm)

        textView.text = "Please enter number"
        //textView2.text = "$random"

        Confirm.setOnClickListener {
            //textView2.text = "$random"
            val number: Int = editText.text.toString().toInt()

            if (number < random) {
                textView.text = "Hint: It's higher!"
                editText.text.clear()
            }

            else if (number > random) {
                textView.text = "Hint: It's lower!"
                editText.text.clear()
            }

            else if (number == random) {
                textView.text = "You WIN !"
            }
        }

        Reset.setOnClickListener {
            random = nextInt(1, 1000)
            textView.text = "Please enter number"
            editText.text.clear()
        }
    }

}