package com.example.enttsd.viewmodels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enttsd.R
import com.example.enttsd.databinding.NaryadFindItemBinding
import com.example.enttsd.models.NaryadModel


class NaryadFindAdapter(private val checkedEvent:(naryad:NaryadModel, addFlag: Boolean)->Unit) :RecyclerView.Adapter<NaryadFindAdapter.NaryadFindHolder>() {
    var naryadList = ArrayList<NaryadModel>()
    class NaryadFindHolder(private val checkedEvent:(naryad:NaryadModel, addFlag: Boolean)->Unit, item:View):RecyclerView.ViewHolder(item){
        val binding = NaryadFindItemBinding.bind(item)
        fun bind(naryad: NaryadModel) = with(binding){
            tvTitleNaryadFindItem.text=naryad.numInOrder.toString()
            tvNoteNaryadFindItem.text = naryad.shet
            binding.btnChNaryadFindItem.setOnClickListener {
                naryad.isChacked=!naryad.isChacked
                checkedEvent(naryad, naryad.isChacked)
                if(naryad.isChacked)
                    binding.btnChNaryadFindItem.setBackgroundResource(R.drawable.ic_baseline_check_circle_24)
                else
                    binding.btnChNaryadFindItem.setBackgroundResource(R.drawable.ic_baseline_check_circle_outline_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaryadFindHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.naryad_find_item, parent, false)
        return NaryadFindHolder(checkedEvent, view)
    }

    override fun onBindViewHolder(holder: NaryadFindHolder, position: Int) {
        holder.bind(naryadList[position])
    }

    override fun getItemCount(): Int {
        return naryadList.size
    }

    fun addNaryads(naryads: ArrayList<NaryadModel>){
        naryadList=naryads
        notifyDataSetChanged()
    }
}