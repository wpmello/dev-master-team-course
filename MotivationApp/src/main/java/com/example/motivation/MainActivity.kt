package com.example.motivation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.model.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNewPhrase.setOnClickListener(this)
        supportActionBar?.hide()

        binding.textUserName.text =
            getString(R.string.user_name, SecurityPreferences(this).getString("USER_NAME"))
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonNewPhrase) {
            val s = ""
        }
    }
}