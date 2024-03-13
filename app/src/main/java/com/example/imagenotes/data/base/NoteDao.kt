package com.example.imagenotes.data.base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("Select * From NoteEntity")
    fun  getAllNotes(): Flow<List<NoteEntity>>

    @Query("""SELECT * FROM NoteEntity WHERE id = :id""")
    suspend fun getNoteById(id: Int): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notentity: NoteEntity)

    @Delete
    suspend fun deleteNote(notentity: NoteEntity)

    @Update
    suspend fun updateNote(notentity: NoteEntity)
}