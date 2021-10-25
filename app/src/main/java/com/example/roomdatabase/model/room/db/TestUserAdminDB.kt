package com.example.roomdatabase.model.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomdatabase.model.room.dao.AdminDao
import com.example.roomdatabase.model.room.dao.UserDao
import com.example.roomdatabase.model.room.entities.AdminEntity
import com.example.roomdatabase.model.room.entities.UserEntity

@Database(entities = [
    UserEntity::class,
    AdminEntity::class
],
version = 1)
abstract class TestUserAdminDB: RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getAdminDao(): AdminDao

}