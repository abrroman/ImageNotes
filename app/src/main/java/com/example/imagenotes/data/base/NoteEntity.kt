package com.example.imagenotes.data.base

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    @PrimaryKey val id: Int?,
    val title: String,
    val content: String,
    val img: String,
    val date: String
)