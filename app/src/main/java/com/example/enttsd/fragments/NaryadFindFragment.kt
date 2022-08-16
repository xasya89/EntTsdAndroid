package com.example.enttsd.fragments

import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentNaryadFindBinding
import com.example.enttsd.models.NaryadModel
import com.example.enttsd.viewmodels.NaryadFindAdapter
import com.example.enttsd.viewmodels.UpakViewModel


class NaryadFindFragment : Fragment() {
    private lateinit var binding: FragmentNaryadFindBinding
    private val adapter = NaryadFindAdapter{naryad -> Toast.makeText(context, naryad.numInOrder, Toast.LENGTH_LONG).show() }
    private val upakViewModel:UpakViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNaryadFindBinding.inflate(inflater)
        binding.tbNaryadFind.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                upakViewModel.search(binding.tbNaryadFind.text.toString())
                return@OnKeyListener true
            }
            false
        })
        initRecycle()
        return binding.root
    }

    private fun initRecycle(){
        binding.apply {
            rcNaryadFind.layoutManager=LinearLayoutManager( activity)

            rcNaryadFind.adapter = adapter
            upakViewModel.naryadSearchedList.observe(viewLifecycleOwner, {
                adapter.addNaryads(it)
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NaryadFindFragment().apply {}
    }
}