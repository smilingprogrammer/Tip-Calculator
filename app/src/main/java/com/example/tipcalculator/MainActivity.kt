package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener { calculateTip() }
    }

    fun calculateTip() {
        val stringInField = binding.costOfService.text.toString()
        val cost = stringInField.toDouble()

        val selectedId = binding.tipOptions.checkedRadioButtonId

        val percentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        val tip = percentage * cost
    }
}