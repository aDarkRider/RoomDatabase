package com.example.roomdatabase.model.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomdatabase.model.room.entities.UserEntity

@Dao
interface UserDao {

    @Insert
    fun insertUserDetails(user: UserEntity)

    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<UserEntity>>

}