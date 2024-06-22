package com.example.mynotes.android.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynotes.notes.data.NotesUseCaseImpl
import com.example.mynotes.notes.domain.NotesData
import com.example.mynotes.notes.domain.NotesUseCase
import com.example.mynotes.notes.presentation.HomeScreenEvent
import com.example.mynotes.notes.presentation.HomeScreenState
import com.example.mynotes.notes.presentation.NotesPresentationViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


/**
 * Written by Vikram Ragu on 12/06/24.
 */
class NotesViewModel(
) : ViewModel() {

    private val useCase: NotesUseCase = NotesUseCaseImpl()

    private val viewModel by lazy {
        NotesPresentationViewModel(
            useCase = useCase,
        )
    }

    val state = viewModel.getStatevalue()

    fun onEvent(event: HomeScreenEvent){
        viewModel.onEvent(event = event)
    }

}