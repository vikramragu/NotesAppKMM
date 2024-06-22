//
//  NotesViewModel.swift
//  iosApp
//
//  Created by Better Opinions on 15/06/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared


extension NotesHome {
    
    
    @MainActor class NotesViewModel : ObservableObject{
        
        private var useCase : NotesUseCase
        private var notesPresentationViewModel : NotesPresentationViewModel
        
        @Published var state = HomeScreenState(isSearching : false, notesList : [])
        
        private var handle : DisposableHandle?
        
        init(useCase: NotesUseCase) {
            self.useCase = useCase
            self.notesPresentationViewModel = NotesPresentationViewModel(useCase: useCase)
        }
        
        
        func onEvent(event : HomeScreenEvent){
            self.notesPresentationViewModel.onEvent(event: event)
        }
        
        func startObserving(){
            handle = notesPresentationViewModel.getStatevalue().subscribe(
                onCollect: { state in
                            if let state = state {
                                self.state = state
                            }
                        }
            )
        }
        
        func dispose(){
            handle?.dispose()
        }
        
    }
}
