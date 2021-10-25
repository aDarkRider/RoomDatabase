package com.example.roomdatabase.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase.databinding.RecyclerViewAdminItemBinding
import com.example.roomdatabase.model.room.entities.AdminEntity
import com.example.roomdatabase.model.room.entities.UserEntity

class AdminAdapter : RecyclerView.Adapter<AdminViewHolder>() {

    private var admins: List<AdminEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdminViewHolder {
        return AdminViewHolder(RecyclerViewAdminItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AdminViewHolder, position: Int) {
        holder.binding.name.text = admins[position].name
        holder.binding.phone.text = admins[position].phone
    }

    fun setAdmins(admins: List<AdminEntity>) {
        this.admins = admins
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return admins.size
    }
}

class AdminViewHolder(val binding: RecyclerViewAdminItemBinding) : RecyclerView.ViewHolder(binding.root)