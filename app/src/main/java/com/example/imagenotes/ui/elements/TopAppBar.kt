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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun topAppBar(){
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top,
            modifier = Modifier.clip(shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)).fillMaxWidth().height(50.dp)
                .background(notePrimary).padding(horizontal = 15.dp))
        {
            Text("ImageNotes", fontWeight = FontWeight.Bold, fontSize = 25.sp, color = noteSecondary)
            IconButton(onClick={}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
            {
                Icon(imageVector = Icons.Filled.Search,
                    contentDescription = "Info Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
            }
        }
}

