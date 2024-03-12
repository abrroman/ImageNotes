package com.example.imagenotes.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.imagenotes.ui.themes.noteBackground

@Composable
fun mainScreen()
{
    Scaffold(
        bottomBar = {},
        topBar = {},
        containerColor = noteBackground
    ) {  innerPadding ->
        Row(modifier= Modifier.padding(innerPadding)){
            Text("Test")
        }
    }
}