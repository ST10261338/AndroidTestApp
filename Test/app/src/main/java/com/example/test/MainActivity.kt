package com.example.test

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets




        }



        //finding UI components by their ids

        val edtBillAmt = findViewById<EditText>(R.id.BillAmt)
        val edtTipPercentage = findViewById<EditText>(R.id.tipPercent)
        val calculate=findViewById<Button>(R.id.btnCalculator)
        val tip = findViewById<TextView>(R.id.txtTipAmt)

        calculate.setOnClickListener() {
            val tipPercentage = edtBillAmt.text.toString().toDoubleOrNull()?:0.0
            val billAmt = edtTipPercentage.text.toString().toDoubleOrNull()?:0.0

            //calculation
            val tipAmount = billAmt * (tipPercentage/100)

            //display
            tip.text = "Tip Amount: R${String.format("%.2f", tipAmount)}"
        }

    }
}