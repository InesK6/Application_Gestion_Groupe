package com.example.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var computeButton: Button
    private lateinit var TextViewClick: TextView
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        TextViewClick = findViewById(R.id.text_view_id)
        clickButton.setOnClickListener {
            nbClick++
            val newText = "Cliquez moi $nbClick"
            if (nbClick > 0) {
                TextViewClick.text = newText
            }
            if (nbClick >= 5) {
                clickButton.isEnabled = false
            }

        }
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }



    }


}
