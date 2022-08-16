package com.example.enttsd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentUpakActListBinding
import com.example.enttsd.models.LoginModel
import com.example.enttsd.viewmodels.LoginRepository

class UpakActListFragment : Fragment() {
    private lateinit var binding:FragmentUpakActListBinding
    private val loginRepository : LoginRepository by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpakActListBinding.inflate(inflater)
        binding.btnAddUpakAct.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragmentContainerView, UpakActFragment.newInstance())
            }
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UpakActListFragment().apply { }
    }
}