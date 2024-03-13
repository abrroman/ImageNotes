package com.example.imagenotes.events

sealed interface UiEvent {
    data class Navigate(val route: String): UiEvent
    object NavigateBack: UiEvent
}