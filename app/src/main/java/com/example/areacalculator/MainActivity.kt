package com.example.areacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    private var calculate: Button ?= null
    private var length: EditText?= null
    private var width: EditText?= null
    private var area: Double?= null
    private var result: TextView?= null
    private var carpetImage: ImageView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateArea = CalculateArea()
        length = findViewById(R.id.length)
        width = findViewById(R.id.width)
        result = findViewById(R.id.result)
        calculate = findViewById(R.id.calculateBtn)
        carpetImage = findViewById(R.id.carpet)

        calculate?.setOnClickListener {
            val inputLength:String = length?.text.toString()
            val inputWidth:String = width?.text.toString()

            var nullInput = false
            var errorMessage = ""

            if (inputLength == "") {
                nullInput = true
                errorMessage += "Please enter a length. "
            }
            if (inputWidth == "") {
                nullInput = true
                errorMessage += "Please enter a width."
            }

            if (nullInput) {
                result?.text = errorMessage
            }
            else {
                area = calculateArea.CalculateArea(inputLength.toDouble(), inputWidth.toDouble())
                result?.text = area.toString()
            }

            result?.isVisible = true
        }
    }
}
