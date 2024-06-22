//
//  AddNotesViewModel.swift
//  iosApp
//
//  Created by Better Opinions on 16/06/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

@MainActor class AddNotesViewModel : ObservableObject{
    
    private var useCase : NotesUseCase
    private var notesPresentationViewModel : NotesPresentationViewModel
        
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
                            //self.state = state
                        }
                    }
        )
    }
    
    func dispose(){
        handle?.dispose()
    }
    
    
}
