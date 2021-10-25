package com.example.roomdatabase.model.view_models.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.model.room.db.TestUserAdminDB
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AdminsDetailFragmentViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var mDatabase: TestUserAdminDB

   fun getAdmins() = mDatabase.getAdminDao().getAdmins()

}