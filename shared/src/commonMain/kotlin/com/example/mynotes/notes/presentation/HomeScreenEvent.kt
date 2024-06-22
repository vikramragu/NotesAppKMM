package com.example.mynotes.notes.presentation


/**
 * Written by Vikram Ragu on 12/06/24.
 */
sealed class HomeScreenEvent{
    data class AddNotes(val title : String, val desc : String) : HomeScreenEvent()
    object GetNotes : HomeScreenEvent()
}