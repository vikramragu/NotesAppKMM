package com.example.mynotes.notes.presentation

import com.example.mynotes.notes.domain.NotesData


/**
 * Written by Vikram Ragu on 12/06/24.
 */
data class HomeScreenState(
    val isSearching : Boolean = false,
    val notesList : List<NotesData> = emptyList()
)