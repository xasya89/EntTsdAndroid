package com.example.enttsd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentLoginBinding
import com.example.enttsd.viewmodels.EntRestViewModel
import com.example.enttsd.viewmodels.LoginRepository

class LoginFragment : Fragment() {
    lateinit var binding : FragmentLoginBinding
    private val loginViewModel:EntRestViewModel by activityViewModels()
    private val loginRepository: LoginRepository by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        loginViewModel.loginModel.observe(viewLifecycleOwner,{
            loginRepository.loginModel.value=it
            parentFragmentManager.commit {
                replace(R.id.fragmentContainerView, MenuFragment.newInstance())
            }
        })
        binding.loginBtn.setOnClickListener {
            loginViewModel.getLogin(binding.loginCardNumber.text.toString())
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment().apply {}
    }
}