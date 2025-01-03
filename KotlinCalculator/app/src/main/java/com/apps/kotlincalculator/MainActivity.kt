package com.apps.kotlincalculator

import android.content.ClipboardManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.content.ClipData
import kotlin.math.sqrt
import kotlin.math.pow

class MainActivity : AppCompatActivity() , View.OnClickListener {

    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMultiply : Button
    lateinit var btnDivision : Button
    lateinit var btnSquare : Button
    lateinit var btnCube : Button
    lateinit var btnPowern : Button
    lateinit var btnSqrt : Button

    lateinit var etA : EditText
    lateinit var etB : EditText

    lateinit var resultTV : TextView

    lateinit var clipboard: ClipboardManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_subtract)
        btnMultiply = findViewById(R.id.btn_multiply)
        btnDivision = findViewById(R.id.btn_divide)
        btnSquare = findViewById(R.id.btn_square)
        btnCube = findViewById(R.id.btn_cube)
        btnPowern = findViewById(R.id.btn_powern)
        btnSqrt = findViewById(R.id.btn_sqrt)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        resultTV = findViewById(R.id.result_tv)

        clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMultiply.setOnClickListener(this)
        btnDivision.setOnClickListener(this)
        btnSquare.setOnClickListener(this)
        btnCube.setOnClickListener(this)
        btnPowern.setOnClickListener(this)
        btnSqrt.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var a  = etA.text.toString().toDouble()
        var b  = etB.text.toString().toDouble()
        var result = 0.0
        var inputInString = " "

        when(v?.id){
            R.id.btn_add ->{
                result = a + b;
                inputInString = "$a + $b = $result"
            }
            R.id.btn_subtract ->{
                result = a - b;
                inputInString = "$a - $b = $result"
            }
            R.id.btn_multiply ->{
                result = a * b;
                inputInString = "$a * $b = $result"
            }
            R.id.btn_divide ->{
                result = a / b;
                inputInString = "$a / $b = $result"
            }
            R.id.btn_square ->{
                result = a*a;
                inputInString = "${a}² = $result"
            }
            R.id.btn_cube ->{
                result = a*a*a;
                inputInString = "${a}³ = $result"
            }
            R.id.btn_powern ->{
                result = Math.pow(a,b);
                inputInString = "${a}ⁿ = $result"
            }
            R.id.btn_sqrt ->{
                result = sqrt(a);
                inputInString = "√$a = $result"
            }
        }
        var clip = ClipData.newPlainText("result is","$result")
        clipboard.setPrimaryClip(clip)

        resultTV.text = "$inputInString"


    }
}

