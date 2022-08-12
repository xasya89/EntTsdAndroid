package com.example.enttsd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentMenuBinding
import com.example.enttsd.viewmodels.LoginRepository

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val loginRepository : LoginRepository by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater)
        loginRepository.loginModel.observe(viewLifecycleOwner,{
            binding.menuUserFio.setText(it.postName)

        })
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MenuFragment().apply {}
    }
}