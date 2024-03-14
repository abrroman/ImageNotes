package com.example.imagenotes.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagenotes.R
import com.example.imagenotes.data.Note
import com.example.imagenotes.ui.themes.noteBackground
import com.example.imagenotes.ui.themes.noteSecondary

@Composable
fun noteCell(item: Note, onNoteClick: (Note) -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(noteBackground).width(200.dp).height(240.dp).padding(5.dp).
        clickable(onClick = { onNoteClick(item) }))
    {
        Row(modifier = Modifier.fillMaxWidth().height(160.dp).border(width = 1.dp, color = noteSecondary,
            shape= RoundedCornerShape(10.dp)), horizontalArrangement = Arrangement.Center)
        {
            Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription = "test_image",
                modifier = Modifier.padding(top=10.dp))
        }
        Row(modifier = Modifier.fillMaxWidth().height(70.dp), horizontalArrangement = Arrangement.Center)
        {
            Column(horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(text=item.title, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = noteSecondary,
                    modifier = Modifier.padding(top=10.dp))
                Text("13.03.2024", fontSize = 15.sp, color = noteSecondary)
            }
        }
    }
}