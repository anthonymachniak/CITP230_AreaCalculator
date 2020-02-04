package com.example.areacalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.view.isVisible

private const val TAG = "MainActivity"
private var orientation : Int ?= null

class MainActivity : AppCompatActivity() {
    private var calculate: Button ?= null
    private var length: EditText?= null
    private var width: EditText?= null
    private var area: Double?= null
    private var result: TextView?= null
    private var carpetImage: ImageView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        orientation = resources.configuration.orientation

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

    fun logAction(message: String) {
        var orientationString = if(orientation == 1) "Portrait" else "Landscape"

        var logMessage = "$message; $orientationString"

        Log.d(TAG, logMessage)

        toastMessage(logMessage)
    }

    fun toastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        orientation = resources.configuration.orientation
        logAction("onRestart")
        super.onRestart()
    }

    override fun onStart() {
        logAction("onStart")
        super.onStart()
    }

    override fun onResume() {
        logAction("onResume")
        super.onResume()
    }

    override fun onPause() {
        logAction("onPause")
        super.onPause()
    }

    override fun onStop() {
        logAction("onStop")
        super.onStop()
    }

    override fun onDestroy() {
        logAction("onDestroy")
        super.onDestroy()
    }
}