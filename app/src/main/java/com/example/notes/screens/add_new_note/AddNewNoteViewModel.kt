package com.example.notes.screens.add_new_note

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.AppNote
import com.example.notes.screens.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewNoteViewModel(application: Application): ViewModel() {

    fun insert(note: AppNote, onSuccess:() -> Unit){
        viewModelScope.launch(Dispatchers.Main){
            REPOSITORY?.insert(note){
                onSuccess()
            }
        }
    }
}