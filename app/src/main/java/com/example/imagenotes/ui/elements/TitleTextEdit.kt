package com.example.imagenotes.ui.elements

import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagenotes.data.base.NoteState
import com.example.imagenotes.events.NoteEvent
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun titleTextEdit(state: NoteState,
                  onEvent: (NoteEvent) -> Unit) {
    val noteTextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = noteSecondary,
        backgroundColor = notePrimary,
        focusedIndicatorColor = notePrimary,
        unfocusedIndicatorColor = notePrimary
    )

    val noteTextStyle = TextStyle(color = noteSecondary, fontWeight = FontWeight.Bold, fontSize = 20.sp)

    TextField(
        value = state.title,
        onValueChange = {onEvent(NoteEvent.TitleChange(it))},
        enabled = true,
        placeholder = {Text("Название", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = noteSecondary)},
        singleLine = true,
        maxLines = 1,
        colors = noteTextFieldColors,
        textStyle = noteTextStyle,
        modifier = Modifier.width(200.dp)
    )
}