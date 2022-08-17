package com.example.enttsd.viewmodels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.enttsd.R
import com.example.enttsd.databinding.NaryadItemActionBinding
import com.example.enttsd.models.NaryadModel

class NaryadActionAdapter(private val onShowAction:(naryad: NaryadModel)->Unit):RecyclerView.Adapter<NaryadActionAdapter.NaryadActionHolder>() {
    private var naryadList = ArrayList<NaryadModel>()
        //ArrayList<NaryadModel>()

    class NaryadActionHolder(private val onShowAction: (naryad: NaryadModel)->Unit, item:View):RecyclerView.ViewHolder(item){
        val binding = NaryadItemActionBinding.bind(item)
        fun bind(naryad : NaryadModel)= with(binding){
            tvTitleNaryadAction.text=naryad.shet
            tvNoteNaryadAction.text=naryad.shet
            btnNaryadAction.setOnClickListener {
                onShowAction(naryad)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NaryadActionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.naryad_item_action, parent, false)
        return NaryadActionHolder(onShowAction, view)
    }

    override fun onBindViewHolder(holder: NaryadActionHolder, position: Int) {
        holder.bind(naryadList[position])
    }

    override fun getItemCount(): Int {
        return naryadList.size
    }

    fun setNaryads(naryads:ArrayList<NaryadModel>){
        naryadList = naryads
        notifyDataSetChanged()
    }

}