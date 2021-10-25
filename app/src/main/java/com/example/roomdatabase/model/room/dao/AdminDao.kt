package com.example.roomdatabase.model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.model.room.entities.AdminEntity

@Dao
interface AdminDao {

    @Insert
    fun insertAdminDetails(admin: AdminEntity)

    @Query("SELECT * FROM admins")
    fun getAdmins(): LiveData<List<AdminEntity>>

}