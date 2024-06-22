//
//  NotesHome.swift
//  iosApp
//
//  Created by Better Opinions on 15/06/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared


struct NotesHome: View {
    
    @ObservedObject var viewModel: NotesViewModel
    private var usecase : NotesUseCase
    
    init(usecase: NotesUseCase) {
        self.usecase = usecase
        self.viewModel = NotesViewModel(useCase: usecase)
    }
    
    
    var body: some View {
        ZStack(content: {
            List(content: {
                Text("NOTES").font(.system(size: 18,weight: Font.Weight.semibold))
                    .foregroundColor(.purple).padding(.bottom,5)
                    .padding(.horizontal,8)
                
                if(viewModel.state.notesList.isEmpty){
                    
                    VStack(content: {
                        Spacer()
                        Text("Empty Screen")
                            .font(.system(size: 24))
                            .bold()
                            .frame(maxWidth: .infinity,alignment: .center)
                            .listRowSeparator(.hidden)
                        Spacer()
                    })
                                        
                } else {
                    
                    ForEach(viewModel.state.notesList,id:\.self){ item in
                        
                        VStack(content: {
                            
                            Text(item.title)
                                .font(.title)
                                .font(.system(size: 24))
                                .bold()
                                .frame(maxWidth: .infinity,alignment: .center)
                                .padding()
                            
                            Text(item.content)
                                .font(.caption)
                                .font(.system(size: 16))
                                .frame(maxWidth: .infinity,alignment: .center)
                        })
                    }
                }
                
            })
            
            VStack{
                Spacer()
                NavigationLink(
                    destination: ParentView(onTextAdded: { title , desc in
                        viewModel.onEvent(event: HomeScreenEvent.AddNotes(title: title, desc: desc))
                    })
                        ,label: {
                    ZStack{
                        Circle().foregroundColor(.purple)
                            .padding()
                        Image(uiImage: UIImage(named: "icons_plus")!)
                            .foregroundColor(.blue)
                                .frame(maxWidth: 30, maxHeight: 30)
                        
                    }.frame(maxWidth: 100, maxHeight: 100)
                })
            }
        }).onAppear(perform: {
            viewModel.startObserving()
        }).onDisappear(perform: {
            viewModel.dispose()
        })
    }
}

#Preview {
    //NotesHome()
    EmptyView()
}
