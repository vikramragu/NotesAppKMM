package com.example.mynotes.notes.domain


/**
 * Written by Vikram Ragu on 12/06/24.
 */
interface NotesUseCase {

    fun addNotes(title: String, desc: String) : Boolean

    fun getAllNotes(): List<NotesData>

}