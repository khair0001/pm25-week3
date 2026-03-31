package com.mobile.week3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainView = findViewById<View>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tilName = findViewById<TextInputLayout>(R.id.tilName)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val btnSayHello = findViewById<Button>(R.id.btnSayHello)
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)

        btnSayHello.setOnClickListener {
            val name = etName.text.toString().trim()
            
            if (name.isNotEmpty()) {
                // Clear error and show greeting
                tilName.error = null
                tvGreeting.text = getString(R.string.greeting_format, name)
                tvGreeting.visibility = View.VISIBLE
            } else {
                // Show error on the TextInputLayout for better UI
                tilName.error = getString(R.string.error_empty_name)
                tvGreeting.visibility = View.INVISIBLE
            }
        }
    }
}