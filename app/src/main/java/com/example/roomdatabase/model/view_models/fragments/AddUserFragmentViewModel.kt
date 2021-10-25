package com.example.roomdatabase.model.view_models.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.model.room.db.TestUserAdminDB
import com.example.roomdatabase.model.room.entities.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AddUserFragmentViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var mDatabase: TestUserAdminDB

    enum class InsertState {
        IDLE, INSERTING, INSERTED
    }
    val insertState = MutableLiveData(InsertState.IDLE)

    fun insertUser(name: String, phone: String, password: String) {
        insertState.value = InsertState.INSERTING
        Observable.just(UserEntity(name, phone, password))
            .filter {
                mDatabase.getUserDao().insertUserDetails(it)
                true
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "insertUser: user has been inserted with name ${it.name}")
            }, {
               it.printStackTrace();
            }, {
                insertState.value = InsertState.INSERTED
            })
    }

    companion object {
        private const val TAG = "AddUserFragmentViewMode"
    }

}