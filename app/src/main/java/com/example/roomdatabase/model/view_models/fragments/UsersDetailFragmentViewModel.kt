package com.example.roomdatabase.model.view_models.fragments

import androidx.lifecycle.ViewModel
import com.example.roomdatabase.model.room.db.TestUserAdminDB
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersDetailFragmentViewModel @Inject constructor(): ViewModel() {

   @Inject lateinit var mDatabase: TestUserAdminDB

   fun getUsers() = mDatabase.getUserDao().getUsers()

}