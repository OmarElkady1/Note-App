package com.example.note.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database( entities = [Note::class],version = 1,exportSchema = false)
abstract class NoteDataBase :RoomDatabase() {
    abstract fun noteDao():NoteDao
    companion object{

         @Volatile
        private var Instance :NoteDataBase ?=null

         fun getInstance(context: Context):NoteDataBase{
             var tempInstace = Instance
             if (tempInstace !=null){
                 return tempInstace
             }
             synchronized(this){
                 var instace = Room.databaseBuilder(
                     context.applicationContext,
                     NoteDataBase::class.java,
                     "Data Base"
                 ).build()
                 Instance = instace
                 return instace
             }


         }

    }

}