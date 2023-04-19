package com.example.motivation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.model.Mock
import com.example.motivation.model.infra.MotivationConstants
import com.example.motivation.model.infra.SecurityPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var category = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        handleFilter(R.id.image_all)

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.textUserName.text =
            getString(R.string.user_name, SecurityPreferences(this).getString("USER_NAME"))
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonNewPhrase) {
            handlePhrase()
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id)
        }
    }

    private fun handlePhrase() {
        val mockPhrase = Mock().getPhrase(category)
        binding.textPhrase.text = mockPhrase.description
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.HAPPY
            }
            else -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.SUNNY
            }
        }
    }
}