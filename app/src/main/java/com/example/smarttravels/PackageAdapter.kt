package com.example.smarttravels

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PackageAdapter(private val packages: List<Package>, private val context: Context) :
    RecyclerView.Adapter<PackageAdapter.PackageViewHolder>() {

    class PackageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val packageName: TextView = itemView.findViewById(R.id.packageName)
        val packageImage: ImageView = itemView.findViewById(R.id.packageImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.package_item, parent, false)
        return PackageViewHolder(view)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val packageItem = packages[position]
        holder.packageName.text = packageItem.name
        // Cargar imagen con Glide o Picasso
        Glide.with(holder.packageImage)
            .load(packageItem.imageUrl)
            .into(holder.packageImage)
        holder.itemView.setOnClickListener {
            // Aquí puedes iniciar la nueva actividad
            val intent = Intent(context, DetallePackageActivity::class.java)
            // Puedes añadir datos adicionales al intent si es necesario
            intent.putExtra("packageId", packageItem.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return packages.size
    }
}
