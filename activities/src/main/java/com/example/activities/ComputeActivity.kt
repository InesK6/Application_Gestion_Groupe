package com.example.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.activities.R

class ComputeActivity : AppCompatActivity() {
    private lateinit var TextViewResultat: TextView
    private lateinit var calculerButton: Button
    private lateinit var Nombre1: EditText
    private lateinit var Nombre2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        TextViewResultat = findViewById(R.id.resultat)
        calculerButton = findViewById(R.id.btn_calculer)
        Nombre1 = findViewById(R.id.field_1)
        Nombre2 = findViewById(R.id.field_2)
        calculerButton.setOnClickListener {
            val resultNb1 = Nombre1.text.toString().toDouble()
            val resultNb2 = Nombre2.text.toString().toDouble()
            val resultText = (resultNb1+resultNb2).toString()
            TextViewResultat.text = "Le résultat de $resultNb1 + $resultNb2 =  $resultText"
        }
        calculerButton.isEnabled = false
        Nombre1.doAfterTextChanged {
            if (Nombre1.text.toString().length <=0 || Nombre2.text.toString().length <=0){
                calculerButton.isEnabled = false
            }
            else{
                calculerButton.isEnabled = true
            }

        }
        Nombre2.doAfterTextChanged {
            if (Nombre1.text.toString().length <=0 || Nombre2.text.toString().length <=0){
                calculerButton.isEnabled = false
            }
            else{
                calculerButton.isEnabled = true
            }
        }


    }
}