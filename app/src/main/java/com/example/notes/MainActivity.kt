package com.example.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.screens.APP_ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        APP_ACTIVITY = this
        val toolbar: Toolbar = binding.toolbar
        toolbar.title = "Заметки"
        setSupportActionBar(toolbar)

    }
}