package com.example.motivation.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.MainActivity
import com.example.motivation.R
import com.example.motivation.databinding.ActivityUserBinding
import com.example.motivation.model.SecurityPreferences

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.saveButton.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.saveButton) {
            testSave()
        }
    }

    private fun testSave() {
        val name = binding.enterNameEdit.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString("USER_NAME", name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()
        }
    }
}