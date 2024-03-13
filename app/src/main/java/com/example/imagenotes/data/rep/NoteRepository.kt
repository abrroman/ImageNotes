package com.example.imagenotes.data.rep

import com.example.imagenotes.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun gettAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun getNoteById(note: Note): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun updateNote(note: Note)


}