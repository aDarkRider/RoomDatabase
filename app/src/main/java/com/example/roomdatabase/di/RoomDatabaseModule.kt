package com.example.roomdatabase.di

import android.content.Context
import androidx.room.Room
import com.example.roomdatabase.model.room.db.TestUserAdminDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDatabaseModule {
    @Provides
    @Singleton
    fun getDatabase(@ApplicationContext context: Context): TestUserAdminDB {
       return Room.databaseBuilder(context, TestUserAdminDB::class.java,"app_room")
           .fallbackToDestructiveMigration()
           .build()
    }
}