package com.example.notes.screens.main

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notes.database.room.AppRoomDatabase
import com.example.notes.database.room.AppRoomRepository
import com.example.notes.model.AppNote
import com.example.notes.screens.REPOSITORY
import com.example.notes.screens.TYPE_ROOM

class MainViewModel(application: Application): ViewModel() {
private val mContext = application

    fun initDatabase(onSuccess:() -> Unit){

                val dao = AppRoomDatabase.getInstance(mContext).getAppRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
    }

    fun getAllNotes(): LiveData<List<AppNote>> {
        return REPOSITORY?.allNotes ?: MutableLiveData(emptyList())
    }
}