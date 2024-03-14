package com.example.imagenotes.ui.note

import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.imagenotes.data.base.NoteState
import com.example.imagenotes.events.NoteEvent
import com.example.imagenotes.ui.elements.contentTextEdit
import com.example.imagenotes.ui.elements.topNoteBar
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteScreen(
    state: NoteState,
    onEvent: (NoteEvent) -> Unit
) {
    val noteButtons = ButtonDefaults.buttonColors(
        backgroundColor = notePrimary,
        contentColor = noteSecondary,
        disabledBackgroundColor = Color.Gray,
        disabledContentColor = Color.White)

    Scaffold(
        topBar = { topNoteBar(state, onEvent)}
    ) { padding ->
        contentTextEdit(state, onEvent, padding)
    }
}