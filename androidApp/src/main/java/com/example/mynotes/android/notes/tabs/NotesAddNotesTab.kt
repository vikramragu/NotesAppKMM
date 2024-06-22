package com.example.mynotes.android.notes.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotes.android.notes.NotesViewModel
import com.example.mynotes.notes.presentation.HomeScreenEvent


/**
 * Written by Vikram Ragu on 13/06/24.
 */
@Composable
fun NotesAddNotesTab(
    viewModel: NotesViewModel,
    onSaveClicked : () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Add Notes",
            fontSize = 24.sp
        )

        val title = remember {
            mutableStateOf("")
        }

        val content = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            value = title.value,
            onValueChange = { item ->
                title.value = item
            }
        )

        Spacer(modifier = Modifier.size(12.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 100.dp),
            value = content.value,
            onValueChange = { item ->
                content.value = item
            }
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 36.dp)
                .height(48.dp),
            onClick = {
                viewModel.onEvent(HomeScreenEvent.AddNotes(
                    title = title.value,
                    desc = content.value
                ))
                onSaveClicked.invoke()
            }, content = {
                Text(text = "Save Data", fontWeight = FontWeight.W500)
            }
        )
    }

}