package com.example.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.RecyclerViewUserItemBinding
import com.example.roomdatabase.model.room.entities.UserEntity

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var users: List<UserEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(RecyclerViewUserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.name.text = users[position].name
        holder.binding.phone.text = users[position].phone
    }

    fun setUsers(users: List<UserEntity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return users.size
    }
}

class UserViewHolder(val binding: RecyclerViewUserItemBinding) : RecyclerView.ViewHolder(binding.root)