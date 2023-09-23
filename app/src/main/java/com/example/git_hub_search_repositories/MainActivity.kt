package com.example.git_hub_search_repositories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.git_hub_search_repositories.databinding.ActivityMainBinding

internal class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()

        binding.textView.text = "Olá, mundo"
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}