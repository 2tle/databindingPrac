package com.example.recyclerviewprac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewprac.databinding.ItemBinding

class RecyclerAdapter (val data: ArrayList<ItemData>, private val OnClick: (data: ItemData, pos: Int) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val recyclerViewHolder = RecyclerViewHolder(ItemBinding.bind(view))
        view.setOnClickListener {
            OnClick(data[recyclerViewHolder.adapterPosition], recyclerViewHolder.adapterPosition)
        }
        return recyclerViewHolder
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerAdapter.RecyclerViewHolder, position: Int) {
        holder.binding.data = data[position]
    }

    inner class RecyclerViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root) {
        //val itemNumberText : TextView = itemView.findViewById(R.id.item_number_text)
        //val itemNameText : TextView = itemView.findViewById(R.id.item_name_Text)


    }


}