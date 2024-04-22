package com.example.smarttravels

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BestForYouAdapter(private val items: List<BestForYouItem>) :
    RecyclerView.Adapter<BestForYouAdapter.BestForYouViewHolder>() {

    class BestForYouViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        val itemName: TextView = itemView.findViewById(R.id.itemName)
        val itemField1: TextView = itemView.findViewById(R.id.itemField1)
        val itemField2: TextView = itemView.findViewById(R.id.itemField2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestForYouViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.best_for_you_item, parent, false)
        return BestForYouViewHolder(view)
    }

    override fun onBindViewHolder(holder: BestForYouViewHolder, position: Int) {
        val currentItem = items[position]
        holder.itemName.text = currentItem.name
        holder.itemField1.text = currentItem.field1
        holder.itemField2.text = currentItem.field2

        // Cargar imagen con Glide o Picasso
        Glide.with(holder.itemImage)
            .load(currentItem.imageUrl)
            .into(holder.itemImage)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    data class BestForYouItem(
        val name: String,
        val imageUrl: String,
        val field1: String,
        val field2: String
    )
}
