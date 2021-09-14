package com.example.note.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.note.data.Note
import com.example.note.data.NoteDataBase
import com.example.note.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) :AndroidViewModel(application) {

     val readAllData :LiveData<List<Note>>
    private val repository :Repository

    init {
        val  noteDao = NoteDataBase.getInstance(application).noteDao()
        repository = Repository(noteDao)
        readAllData=repository.readAllData
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addnote(note)
        }

    }
    fun updateNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNote(note)
        }
    }
}