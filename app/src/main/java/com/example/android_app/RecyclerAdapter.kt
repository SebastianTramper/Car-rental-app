package com.example.android_app

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titles = arrayOf("Tesla Model S", "", "Tesla Model X", "Mazda CX3", "Volkswagen Arteon", "Car F", "Car G", "Car H")
    private var details = arrayOf("A", "B", "C", "D", "E", "F", "G", "H")
    private val images = intArrayOf(
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
        R.drawable.astra,
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        var v = LayoutInflater.from(parent.context).inflate(R.layout.layout_listed_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
        Log.d("RecyclerAdapter", "on bind view holder with position: $position")
    }

    override fun getItemCount(): Int {
        Log.d("RecyclerAdapter", "Size is ${titles.size}")
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_details)

            itemView.setOnClickListener {
                val position: Int = bindingAdapterPosition
                Toast.makeText(itemView.context, "you clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }

    }
}