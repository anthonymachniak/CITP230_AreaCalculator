package com.example.areacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var calculate : Button = findViewById(R.id.calculateBtn)
    private var length: EditText?= null
    private var width: EditText?= null
    private var area: Double?= null
    private var result: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateArea = CalculateArea()
        length = findViewById(R.id.length)
        width = findViewById(R.id.width)
        result = findViewById(R.id.result)

        calculate.setOnClickListener {
            val inputLength:Double = length?.text.toString().toDouble()
            val inputWidth:Double = width?.text.toString().toDouble()
            area = calculateArea.CalculateArea(inputLength, inputWidth)
            result?.text = area.toString()
        }
    }
}
