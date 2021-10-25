package com.example.roomdatabase.model.view_models.fragments

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomdatabase.model.room.db.TestUserAdminDB
import com.example.roomdatabase.model.room.entities.AdminEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class AddAdminFragmentViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var mDatabase: TestUserAdminDB

    enum class InsertState {
        IDLE, INSERTING, INSERTED
    }

    val insertState = MutableLiveData(InsertState.IDLE)

    fun insertAdmin(name: String, phone: String, password: String) {
        insertState.value = InsertState.INSERTING
        Observable.just(AdminEntity(name, phone, password))
            .filter {
                mDatabase.getAdminDao().insertAdminDetails(it)
                true
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d(TAG, "insertAdmin: admin has been inserted with name ${it.name}")
            }, {
                it.printStackTrace()
            }, {
                insertState.value = InsertState.INSERTED
            })
    }

    companion object {
        private const val TAG = "AddAdminFragmentViewMod"
    }

}