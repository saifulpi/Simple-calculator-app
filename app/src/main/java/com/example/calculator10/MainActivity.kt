package com.example.calculator10

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var display : TextView
    var operator = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        display = findViewById(R.id.txtResult)

        findViewById<Button>(R.id.btn0).setOnClickListener { display.append("0") }
        findViewById<Button>(R.id.btn1).setOnClickListener { display.append("1") }
        findViewById<Button>(R.id.btn2).setOnClickListener { display.append("2") }
        findViewById<Button>(R.id.btn3).setOnClickListener { display.append("3") }
        findViewById<Button>(R.id.btn4).setOnClickListener { display.append("4") }
        findViewById<Button>(R.id.btn5).setOnClickListener { display.append("5") }
        findViewById<Button>(R.id.btn6).setOnClickListener { display.append("6") }
        findViewById<Button>(R.id.btn7).setOnClickListener { display.append("7") }
        findViewById<Button>(R.id.btn8).setOnClickListener { display.append("8") }
        findViewById<Button>(R.id.btn9).setOnClickListener { display.append("9") }

        findViewById<Button>(R.id.btnDot).setOnClickListener { display.append(".") }
        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            operator = "+"
            display.append("+") }
        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            operator = "-"
            display.append("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener {
            operator = "x"
            display.append("x") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            operator = "/"
            display.append("/") }
        findViewById<Button>(R.id.btnPercent).setOnClickListener {
            operator = "%"
            display.append("%")
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val expression = display.text.toString()
            if (operator.isNotEmpty()){
                val part = expression.split(operator)
                if(part.size == 2){
                    val first = part[0].toDouble()
                    val second = part[1].toDouble()
                    if(operator == "+"){
                        display.text = (first + second).toInt().toString()
                    }
                    else if(operator == "-"){
                        display.text = (first - second).toInt().toString()
                    }
                    else if(operator == "x"){
                        display.text = (first * second).toInt().toString()
                    }
                    else if(operator == "/"){
                        if(second == 0.0){
                            display.text = "Math error"
                        }
                        else{
                            display.text = (first / second).toString()
                        }
                    }
                    else if(operator == "%"){
                        display.text = (first % second).toString()
                    }
                    else{
                        display.text = 0.toString()
                    }
                    operator = ""
                }
            }
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            val text = display.text.toString()
            if(text.isNotEmpty()){
                display.text = text.substring(0 , text.length - 1)
            }
            else{
                display.text = ""
            }
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            display.text = ""
            operator = ""
        }
    }
}