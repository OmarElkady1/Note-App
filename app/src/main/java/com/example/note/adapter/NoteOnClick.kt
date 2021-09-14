package com.example.note.adapter

import com.example.note.data.Note

interface NoteOnClick {
    fun clickListner(position: Note)
}