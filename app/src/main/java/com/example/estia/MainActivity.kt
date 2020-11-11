package com.example.estia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showWebPage()
        callMe()
    }


    fun showWebPage() {
        val chemin: Uri = Uri.parse("http://www.google.fr")
        val naviguer = Intent(Intent.ACTION_VIEW, chemin)
        startActivity(naviguer)
    }


    fun callMe() {
        val numero = Uri.parse("tel: 0771288323")
        val appeler = Intent(Intent.ACTION_DIAL, numero)
        startActivity(appeler)
    }

}