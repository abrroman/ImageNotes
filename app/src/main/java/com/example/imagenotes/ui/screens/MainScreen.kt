package com.example.imagenotes.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.imagenotes.data.Note
import com.example.imagenotes.ui.elements.floatButton
import com.example.imagenotes.ui.elements.noteCell
import com.example.imagenotes.ui.elements.topAppBar
import com.example.imagenotes.ui.themes.noteBackground
import com.example.imagenotes.ui.themes.notePrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainScreen(noteList: List<Note>,
               onNoteClick: (Note) -> Unit,
               addNoteClick: () -> Unit)
{
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())
    val noteTopAppBar = TopAppBarDefaults.largeTopAppBarColors(containerColor = notePrimary)

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        bottomBar = {},
        topBar = {
            LargeTopAppBar(
                title = { topAppBar() },
                scrollBehavior = scrollBehavior,
                colors = noteTopAppBar
            )
        },
        floatingActionButton = { floatButton(addNoteClick) },
        floatingActionButtonPosition = FabPosition.End,
        containerColor = noteBackground
    ) { padding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(horizontal = 15.dp, vertical = padding.calculateTopPadding()),
                horizontalArrangement = Arrangement.Center,
            ) {
                items(noteList) { item ->
                    noteCell(item, onNoteClick)
                }
            }
    }
}