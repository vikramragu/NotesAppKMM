package com.example.mynotes.notes.presentation

import com.example.mynotes.notes.domain.NotesUseCase
import com.example.mytranslate.core.util.asCommonFlow
import com.example.mytranslate.core.util.toCommonStateFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update


/**
 * Written by Vikram Ragu on 12/06/24.
 */
class NotesPresentationViewModel(
    private val useCase: NotesUseCase
) {

    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState())

    fun onEvent(event: HomeScreenEvent) {
        when (event) {

            is HomeScreenEvent.AddNotes -> {
                addNotes(title = event.title, desc = event.desc)
            }

            is HomeScreenEvent.GetNotes -> {
                getAllNotes()
            }
        }
    }


    fun getStatevalue() = _state.toCommonStateFlow()


    fun addNotes(title: String, desc: String) {
        if (useCase.addNotes(title = title, desc = desc)) {
            _state.update {
                it.copy(notesList = useCase.getAllNotes())
            }
        }
    }

    fun getAllNotes() {
        _state.update {
            it.copy(notesList = useCase.getAllNotes())
        }
    }
}