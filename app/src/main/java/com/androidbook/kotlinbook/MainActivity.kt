package com.androidbook.kotlinbook

import android.R.attr.text
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //#3
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//
//    }
//
//    fun onBookClick(view: View?){
//
//        Toast.makeText(getApplicationContext(),"도서 쇼핑몰을 시작합니다",
//            Toast.LENGTH_LONG).show()
//    }

    //#4
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editText1 = findViewById(R.id.edit_1)
        editText2 = findViewById(R.id.edit_2)

    }

    fun onBookClick(view: View?){
        val editSum = editText1.text.toString().toInt() + editText2.text.toString().toInt()

        if (editSum == 7)
            Toast.makeText(getApplicationContext(),"정답",
            Toast.LENGTH_LONG).show()
        else
            Toast.makeText(getApplicationContext(),"오답",
                Toast.LENGTH_LONG).show()
    }
}