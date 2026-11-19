package com.example.databindingapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.databindingapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val textView = findViewById<TextView>(R.id.textView1)
//        textView.text = "Hello My Friends!"

        var v1 = Vehicle(modelYear = "2024", name = "BMW")
//        binding.textView1.text = v1.name
        binding.myVehicle = v1
        binding.textView1.setOnClickListener {
            Toast.makeText(this, "Clicked ${v1.name}", Toast.LENGTH_SHORT).show()
        }

    }
}

data class Vehicle(val modelYear: String, val name: String)