package com.example.imagenotes.ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun floatButton(){
    IconButton(onClick={})
    {
        Surface(
            shadowElevation = 9.dp, // play with the elevation values
            shape = CircleShape
        ) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier.clip(shape = CircleShape).background(notePrimary).size(70.dp)) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Info Icon",
                    tint = noteSecondary,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}