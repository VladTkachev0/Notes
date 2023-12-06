package com.example.notes.screens.note

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notes.model.AppNote
import com.example.notes.screens.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): ViewModel() {

    fun delete(note: AppNote, onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.Main) {
        REPOSITORY?.delete(note){
                onSuccess()
        }
    }
}