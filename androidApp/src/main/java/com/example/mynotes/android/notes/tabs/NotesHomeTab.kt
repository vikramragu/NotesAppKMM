package com.example.mynotes.android.notes.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FabPosition
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mynotes.android.R
import com.example.mynotes.android.notes.NotesViewModel
import com.example.mynotes.notes.domain.NotesData
import com.example.mynotes.notes.presentation.HomeScreenEvent


/**
 * Written by Vikram Ragu on 13/06/24.
 */

@Composable
fun NotesHomeTab(
    viewModel: NotesViewModel,
    onAddClicked : () -> Unit
) {

    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            IconButton(
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = MaterialTheme.colors.primary.copy(alpha = 0.5f),
                    contentColor = Color.White
                ),
                onClick = {
                    onAddClicked.invoke()
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = ""
                    )
                }
            )
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it)) {

                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "NOTES",
                    fontWeight = FontWeight.W600,
                    fontSize = 48.sp,
                    color = MaterialTheme.colors.primary
                )

                HandleNotes(viewModel = viewModel)
            }
        }
    )
}


@Composable
fun HandleNotes(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.onEvent(HomeScreenEvent.GetNotes)
    }

    val result = viewModel.state.collectAsStateWithLifecycle()

    if (result.value.notesList.isEmpty()) {
        EmptyScreen(
            modifier = modifier
        )
    } else {
        NotesListScreen(
            modifier = modifier,
            list = result.value.notesList
        )
    }
}

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.LightGray.copy(alpha = 0.2f)),
        content = {

            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                content = {

                    Image(
                        modifier = Modifier.padding(16.dp),
                        painter = painterResource(id = R.drawable.baseline_border_clear_24),
                        contentDescription = ""
                    )

                    Text(
                        color = MaterialTheme.colors.primary,
                        fontSize = 16.sp,
                        text = "Empty Content",
                        fontWeight = FontWeight.W600
                    )
                }
            )
        }
    )

}


@Composable
fun NotesListScreen(
    modifier: Modifier = Modifier,
    list: List<NotesData>
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {

        this.items(items = list){
            NotesItem(notesData = it)
        }
    }
}

@Composable
fun NotesItem(
    modifier: Modifier = Modifier,
    notesData: NotesData
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {

        Text(text = notesData.title, fontWeight = FontWeight.W600, fontSize = 18.sp)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = notesData.content, fontWeight = FontWeight.W400)

    }


}