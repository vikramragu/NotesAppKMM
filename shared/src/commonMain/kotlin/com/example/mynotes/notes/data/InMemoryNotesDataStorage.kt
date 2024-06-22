package com.example.mynotes.notes.data

import com.example.mynotes.notes.domain.NotesData


/**
 * Written by Vikram Ragu on 12/06/24.
 */
class InMemoryNotesDataStorage private constructor() {

    companion object {

        private var inMemoryNotesDataStorage: InMemoryNotesDataStorage? = null

        fun getInstance(): InMemoryNotesDataStorage {
            return if (inMemoryNotesDataStorage == null) {
                inMemoryNotesDataStorage = InMemoryNotesDataStorage()
                return inMemoryNotesDataStorage!!
            } else {
                inMemoryNotesDataStorage!!
            }
        }
    }


    private val notesStorageList = ArrayList<NotesData>()

    fun addNotes(title: String, desc: String): Boolean {
        val notes = NotesData(title = title, content = desc)
        return notesStorageList.add(notes)
    }

    fun getAllNotes(): List<NotesData> {
        return notesStorageList.toList()
    }

}