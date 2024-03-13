package com.example.imagenotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.imagenotes.data.Note
import com.example.imagenotes.ui.elements.floatButton
import com.example.imagenotes.ui.elements.noteCell
import com.example.imagenotes.ui.elements.topAppBar
import com.example.imagenotes.ui.themes.noteBackground

@Composable
fun mainScreen(noteList: List<Note>,
               onNoteClick: (Note) -> Unit,
               addNoteClick: () -> Unit)
{
    Scaffold(
        bottomBar = {},
        topBar = { topAppBar() },
        floatingActionButton = { floatButton(addNoteClick) },
        floatingActionButtonPosition = FabPosition.End,
        containerColor = noteBackground
    ) { padding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 15.dp, vertical = padding.calculateTopPadding()),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(noteList) { item ->
                    noteCell(item)
                }
            }
    }
}