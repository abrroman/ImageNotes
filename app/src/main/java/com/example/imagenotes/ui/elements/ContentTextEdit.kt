package com.example.imagenotes.ui.elements

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import com.example.imagenotes.ui.themes.noteBackground
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagenotes.data.base.NoteState
import com.example.imagenotes.events.NoteEvent
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun contentTextEdit(state: NoteState, onEvent: (NoteEvent) -> Unit, padding: PaddingValues) {
    val noteTextFieldColors = TextFieldDefaults.textFieldColors(
        textColor = noteSecondary,
        backgroundColor = noteBackground,
        focusedIndicatorColor = noteBackground,
        unfocusedIndicatorColor = noteBackground
    )

    val noteTextStyle = TextStyle(color = noteSecondary, fontSize = 17.sp)

    TextField(
        value = state.content,
        onValueChange = {onEvent(NoteEvent.ContentChange(it))},
        enabled = true,
        placeholder = {Text("Заметка...", fontSize = 17.sp, color = noteSecondary)},
        colors = noteTextFieldColors,
        textStyle = noteTextStyle,
        modifier = Modifier.fillMaxSize().padding(padding).padding(
                horizontal = 20.dp,
                vertical = 15.dp
            )
    )
}