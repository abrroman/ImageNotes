package com.example.imagenotes.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagenotes.events.NoteEvent
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun topNoteBar(onEvent: (NoteEvent) -> Unit){
    Surface(
        shadowElevation = 9.dp,
        shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top,
            modifier = Modifier.clip(shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)).fillMaxWidth().height(50.dp)
                .background(notePrimary).padding(horizontal = 15.dp))
        {
            IconButton(onClick={onEvent(NoteEvent.NavigateBack)}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
            {
                Icon(imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "Back Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
            }
            Text("ImageNotes", fontWeight = FontWeight.Bold, fontSize = 25.sp, color = noteSecondary)
            IconButton(onClick={onEvent(NoteEvent.DeleteNote)}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
            {
                Icon(imageVector = Icons.Rounded.Delete,
                    contentDescription = "Delete Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
            }
        }
    }
}