package com.example.imagenotes.data.di

import android.content.Context
import androidx.room.Room
import com.example.imagenotes.data.base.NoteDatabase
import com.example.imagenotes.data.rep.NoteRepository
import com.example.imagenotes.data.rep.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, NoteDatabase.name).build()

    @Provides
    @Singleton
    fun provideNoteRep(database: NoteDatabase): NoteRepository = NoteRepositoryImpl(dao = database.dao)


}