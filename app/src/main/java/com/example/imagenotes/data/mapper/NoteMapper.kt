package com.example.imagenotes.data.mapper

import com.example.imagenotes.data.Note
import com.example.imagenotes.data.base.NoteEntity

fun NoteEntity.asExternalModel(): Note = Note(id, title, content, img, date)

fun Note.toEntity(): NoteEntity = NoteEntity(id, title, content, img, date)