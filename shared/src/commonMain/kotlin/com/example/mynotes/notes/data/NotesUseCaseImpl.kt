package com.example.mynotes.notes.data

import com.example.mynotes.notes.domain.NotesData
import com.example.mynotes.notes.domain.NotesUseCase


/**
 * Written by Vikram Ragu on 12/06/24.
 */
class NotesUseCaseImpl() : NotesUseCase {

    private val inMemoryNotesDataStorage = InMemoryNotesDataStorage.getInstance()

    override fun addNotes(title: String, desc: String): Boolean {
        return inMemoryNotesDataStorage.addNotes(title = title, desc = desc)
    }

    override fun getAllNotes(): List<NotesData> {
       return inMemoryNotesDataStorage.getAllNotes()
    }

}