package com.example.myandroiddevhw01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myandroiddevhw01.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var counter = 0
        var counterLimit = 50
        if (counter == 0) binding.minusButton.isEnabled = false

        binding.plusButton.setOnClickListener {
            if (counter < counterLimit) {
                binding.titleText.setTextColor(Color.BLUE)
                counter++
                binding.titleText.text = "Осталось мест: " + (counterLimit - counter - 1).toString()
                binding.minusButton.isEnabled = true
            }
            if (counter == counterLimit) {
                binding.plusButton.isEnabled = false
                binding.resetButton.visibility = View.VISIBLE
                binding.resetButton.isEnabled = true
                binding.titleText.setTextColor(Color.RED)
                binding.titleText.text = "Пассажиров слишком много!"
            }
            binding.textViewCount.text = counter.toString()
        }

        binding.minusButton.setOnClickListener {
            if (counter > 0) {
                counter--
                binding.titleText.text = "Осталось мест: " + (counterLimit - counter - 1).toString()

                if (counter < counterLimit) {
                    binding.plusButton.isEnabled = true
                    binding.titleText.setTextColor(Color.BLUE)
                    binding.resetButton.visibility = View.INVISIBLE
                }
                if (counter == 0) {
                    binding.titleText.text = "Все места свободны"
                    binding.titleText.setTextColor(Color.parseColor("#047a17"))
                    binding.minusButton.isEnabled = false
                }
                binding.textViewCount.text = counter.toString()
            }
        }

        binding.resetButton.setOnClickListener {
            counter = 0
            binding.titleText.setTextColor(Color.parseColor("#047a17"))
            binding.minusButton.isEnabled = false
            binding.plusButton.isEnabled = true
            binding.titleText.text = "Все места свободны"
            binding.resetButton.visibility = View.INVISIBLE
            binding.textViewCount.text = counter.toString()
        }
    }
}