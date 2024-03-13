package com.example.imagenotes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagenotes.events.Route
import com.example.imagenotes.events.UiEvent
import com.example.imagenotes.models.NoteListViewModel
import com.example.imagenotes.models.NoteViewModel
import com.example.imagenotes.ui.note.NoteScreen
import com.example.imagenotes.ui.screens.mainScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Color.parseColor("#FF740F")
            window.navigationBarColor = Color.parseColor("#F0F0F0")
            val controller = WindowInsetsControllerCompat(window, window.decorView)
            controller.isAppearanceLightStatusBars = true

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Route.noteList
            ) {
                composable(route = Route.noteList) {
                    val viewModel = hiltViewModel<NoteListViewModel>()
                    val noteList by viewModel.noteList.collectAsStateWithLifecycle()

                    mainScreen(
                        noteList = noteList,
                        onNoteClick = {
                            navController.navigate(
                                Route.note.replace(
                                    "{id}",
                                    it.id.toString()
                                )
                            )
                        },
                        addNoteClick = {navController.navigate(Route.note)}
                    )
                }

                composable(route = Route.note) {
                    val viewModel = hiltViewModel<NoteViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    LaunchedEffect(key1 = true) {
                        viewModel.event.collect { event ->
                            when (event) {
                                is UiEvent.NavigateBack -> {
                                    navController.popBackStack()
                                }

                                else -> Unit
                            }
                        }
                    }

                    NoteScreen(
                        state = state,
                        onEvent = viewModel::onEvent
                    )
                }
            }
        }
    }
}