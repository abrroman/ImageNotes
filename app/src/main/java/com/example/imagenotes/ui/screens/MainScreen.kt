package com.example.imagenotes.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.imagenotes.data.Note
import com.example.imagenotes.ui.elements.floatButton
import com.example.imagenotes.ui.elements.topAppBar
import com.example.imagenotes.ui.themes.noteBackground

@Composable
fun mainScreen(noteList: List<Note>,
               onNoteClick: (Note) -> Unit)
{
    Scaffold(
        bottomBar = {},
        topBar = { topAppBar() },
        floatingActionButton = { floatButton() },
        floatingActionButtonPosition = FabPosition.End,
        containerColor = noteBackground
    ) {  padding ->
        LazyColumn(
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 15.dp + padding.calculateTopPadding(), bottom = 15.dp + padding.calculateBottomPadding())
        ) {
            item{
                Text(
                    text = "Notes",
                    style = MaterialTheme.typography.titleLarge
                )
            }
            items(noteList) { note ->
                ListItem(
                    headlineContent = {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.titleMedium
                        )
                    },
                    supportingContent = {
                        Text(
                            text = note.content,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    modifier = Modifier.clickable(onClick= {onNoteClick(note)})
                )
            }
        }
    }
}