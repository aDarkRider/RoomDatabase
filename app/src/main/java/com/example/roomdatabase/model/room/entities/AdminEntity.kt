package com.example.roomdatabase.model.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admins")
class AdminEntity (
    val name: String,
    val phone: String,
    val password: String
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}