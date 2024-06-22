package com.example.mynotes.android.notes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mynotes.android.notes.tabs.NotesAddNotesTab
import com.example.mynotes.android.notes.tabs.NotesHomeTab


/**
 * Written by Vikram Ragu on 12/06/24.
 */

typealias TabScreen = @Composable () -> Unit

const val MAIN_SCREEN = "Main Screen"
const val ADD_NOTES = "Add Notes"

sealed class NotesAppTab(val route: String) {

    object NotesMainScreen : NotesAppTab(MAIN_SCREEN)

    object NotesAddNotesScreen : NotesAppTab(ADD_NOTES)
}


@Composable
fun NotesNavigator(
    modifier: Modifier = Modifier,
    viewModel: NotesViewModel
) {
    
    val controller = rememberNavController()

    NavHost(
        modifier = modifier,
        navController = controller,
        startDestination = NotesAppTab.NotesMainScreen.route
    ){

        this.composable(NotesAppTab.NotesMainScreen.route){
            NotesHomeTab(
                viewModel = viewModel,
                onAddClicked = {
                    controller.navigate(NotesAppTab.NotesAddNotesScreen.route)
                }
            )
        }

        this.composable(NotesAppTab.NotesAddNotesScreen.route){
                NotesAddNotesTab(
                    viewModel = viewModel,
                    onSaveClicked = {
                        controller.navigateUp()
                    }
                )
        }

    }
}