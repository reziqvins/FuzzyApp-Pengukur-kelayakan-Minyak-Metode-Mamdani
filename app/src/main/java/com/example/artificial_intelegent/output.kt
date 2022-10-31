package com.example.artificial_intelegent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artificial_intelegent.databinding.ActivityOutputBinding

class output : AppCompatActivity() {
    var result : String? = ""
    private lateinit var binding : ActivityOutputBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        result = intent?.getStringExtra("result")
        binding.TvHasil.text = result
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this,MainActivity::class.java).also{
            result = ""
        })
    }
}