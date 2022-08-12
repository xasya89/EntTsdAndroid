package com.example.enttsd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.enttsd.databinding.ActivityMainBinding
import com.example.enttsd.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, LoginFragment.newInstance())
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView,LoginFragment.newInstance())

        }
    }
}