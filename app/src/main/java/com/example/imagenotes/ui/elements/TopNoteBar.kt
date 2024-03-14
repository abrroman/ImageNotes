package com.example.imagenotes.ui.elements

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AttachFile
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagenotes.data.base.NoteState
import com.example.imagenotes.events.NoteEvent
import com.example.imagenotes.ui.themes.notePrimary
import com.example.imagenotes.ui.themes.noteSecondary

@SuppressLint("RememberReturnType")
@Composable
fun topNoteBar(state: NoteState,
               onEvent: (NoteEvent) -> Unit){
    Surface(
        shadowElevation = 9.dp
    ) {
        Column{
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().height(60.dp)
                    .background(notePrimary).padding(horizontal = 15.dp))
            {
                IconButton(onClick={onEvent(NoteEvent.NavigateBack)}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
                {
                    Icon(imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "Back Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
                }
                titleTextEdit(state, onEvent)
                IconButton(onClick={onEvent(NoteEvent.Save)}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
                {
                    Icon(imageVector = Icons.Rounded.Save ,
                        contentDescription = "Save Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
                }
                IconButton(onClick={}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
                {
                    Icon(imageVector = Icons.Rounded.AttachFile ,
                        contentDescription = "Attach Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
                }
                IconButton(onClick={onEvent(NoteEvent.DeleteNote)}, modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp))
                {
                    Icon(imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete Icon", tint = noteSecondary, modifier = Modifier.size(30.dp))
                }
            }
            Divider(thickness = 3.dp, color = noteSecondary)
        }

    }

}