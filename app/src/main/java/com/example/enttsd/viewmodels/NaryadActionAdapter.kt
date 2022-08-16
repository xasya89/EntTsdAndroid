package com.example.enttsd.viewmodels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enttsd.R
import com.example.enttsd.databinding.NaryadItemActionBinding
import com.example.enttsd.models.NaryadModel

class NaryadActionAdapter:RecyclerView.Adapter<NaryadActionAdapter.NaryadActionHolder>() {
    private var naryadList = ArrayList<NaryadModel>()
    class NaryadActionHolder(item:View):RecyclerView.ViewHolder(item){
        val binding = NaryadItemActionBinding.bind(item)
        fun bind(naryad : NaryadModel)= with(binding){
            tvTitleNaryadAction.text=naryad.shet
            tvNoteNaryadAction.text=naryad.shet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaryadActionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.naryad_item_action, parent, false)
        return NaryadActionHolder(view)
    }

    override fun onBindViewHolder(holder: NaryadActionHolder, position: Int) {
        holder.bind(naryadList[position])
    }

    override fun getItemCount(): Int {
        return naryadList.size
    }


}