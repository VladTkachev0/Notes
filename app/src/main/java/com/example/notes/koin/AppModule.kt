package com.example.notes.koin

import com.example.notes.screens.add_new_note.AddNewNoteViewModel
import com.example.notes.screens.main.MainViewModel
import com.example.notes.screens.note.NoteViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
viewModel { MainViewModel(androidApplication())}
viewModel { AddNewNoteViewModel(androidApplication()) }
    viewModel { NoteViewModel(androidApplication()) }
}