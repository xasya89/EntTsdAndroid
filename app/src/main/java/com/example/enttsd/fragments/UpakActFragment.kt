package com.example.enttsd.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.enttsd.R
import com.example.enttsd.databinding.FragmentUpakActBinding
import com.example.enttsd.viewmodels.LoginRepository
import com.google.android.material.tabs.TabLayoutMediator

class UpakActFragment : Fragment() {
    private var idAct: Int? = null
    private lateinit var binding : FragmentUpakActBinding
    private val loginRepository : LoginRepository by activityViewModels()
    private val fragmentList = listOf(UpakEditFragment.newInstance("",""), NaryadFindFragment.newInstance())
    private val tabItems = listOf("Сканирование", "Поиск")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            idAct = it.getInt("idAct")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpakActBinding.inflate(inflater)
        val vpAdapter = Vp2Adapter(this, fragmentList)
        binding.vpUpak.adapter=vpAdapter
        TabLayoutMediator(binding.tblUpak,binding.vpUpak){
            tab, pos -> tab.text=tabItems[pos]
        }.attach()
        return  binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(idAct: Int? = null) =
            UpakActFragment().apply {
                arguments = Bundle().apply {
                    if (idAct != null) {
                        putInt("idAct", idAct)
                    }
                }
            }
    }
}