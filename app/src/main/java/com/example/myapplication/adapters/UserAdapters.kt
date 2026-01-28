package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.User
import com.example.myapplication.databinding.RowBinding

class MyAdapter :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var users = emptyList<User>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = RowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val user = users[position]
        holder.id.text = user.id.toString()
        holder.firstName.text = user.firstName
        holder.secondName.text = user.lastName
        holder.age.text = "(${user.age})"
    }

    override fun getItemCount(): Int {
        return users.size
    }


    class MyViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root) {
        val firstName: TextView = binding.firstName
        val secondName: TextView = binding.lastName
        val age: TextView = binding.age
        val id: TextView = binding.id
    }

    fun setData(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }


}
