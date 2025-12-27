package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val dogsList: ArrayList<Dog>, private val onItemClick: (Dog) -> Unit) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = dogsList[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title

        holder.itemView.setOnClickListener {
            onItemClick(currentItem)
        }

    }

    override fun getItemCount(): Int {
        return dogsList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ShapeableImageView = itemView.findViewById(R.id.img)
        val title: TextView = itemView.findViewById(R.id.title)
    }


}