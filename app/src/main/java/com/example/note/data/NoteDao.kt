package com.example.note.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)
    @Update
    suspend fun UpdateNote(note: Note)

    @Query("select * from note_table ")
     fun readNote():LiveData<List<Note>>
}