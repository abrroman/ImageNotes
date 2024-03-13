package com.example.imagenotes.data.rep

import com.example.imagenotes.data.Note
import com.example.imagenotes.data.base.NoteDao
import com.example.imagenotes.data.mapper.asExternalModel
import com.example.imagenotes.data.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val dao: NoteDao): NoteRepository {

    override fun gettAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map { notes -> notes.map {it.asExternalModel()}}
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.asExternalModel()
    }

    override suspend fun getNoteById(note: Note): Note? {
        return note.id?.let { dao.getNoteById(it)?.asExternalModel() }
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note.toEntity())
    }

}