package com.example.note.data

import androidx.lifecycle.LiveData

class Repository (private var noteDao: NoteDao) {

    val readAllData : LiveData<List<Note>> = noteDao.readNote()
   suspend fun addnote(note: Note){
        noteDao.addNote(note)
    }
    suspend fun updateNote(note: Note){
        noteDao.UpdateNote(note)
    }
}