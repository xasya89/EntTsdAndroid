package com.example.enttsd.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentUpakEditBinding
import com.example.enttsd.viewmodels.NaryadActionAdapter
import com.example.enttsd.viewmodels.NaryadFindAdapter
import com.example.enttsd.viewmodels.UpakViewModel

class UpakEditFragment : Fragment() {
    private lateinit var binding: FragmentUpakEditBinding
    private val adapter = NaryadActionAdapter{ naryad ->  }
    private val upakViewModel : UpakViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpakEditBinding.inflate(inflater)
        initRecycle()
        return binding.root
    }

    private fun initRecycle() = with(binding){
        rcUpakActEdit.layoutManager = LinearLayoutManager(activity)
        rcUpakActEdit.adapter = adapter
        upakViewModel.naryadList.observe(viewLifecycleOwner,{
            adapter.setNaryads(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            UpakEditFragment().apply { }
    }
}