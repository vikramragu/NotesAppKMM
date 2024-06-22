//
//  AddNotes.swift
//  iosApp
//
//  Created by Better Opinions on 16/06/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI


struct ParentView: View {
    
    @State private var titleText = ""
    @State private var descText = ""
    
    var onTextAdded : (String, String) -> Void
    
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        NavigationView {
            VStack {
                AddNotes(titleText: $titleText, descText: $descText) { title, desc in
                    // Handle the save action here
                    print("The value of myVariable is final: \(titleText) \(descText)")
                    onTextAdded(title, desc)
                    presentationMode.wrappedValue.dismiss()
                }
                
                Spacer()
            }
            .navigationBarTitle("Add Notes", displayMode: .inline)
        }
    }
}


struct AddNotes: View {
    
    @Binding var titleText : String
    @Binding var descText : String
    let onSaveClicked : (String, String) -> Void
    
    
    var body: some View {
        VStack(content: {
            
            TextEditor(text: $titleText)
                .frame(width: .infinity,
                       height: 64,alignment: .topLeading)
                .padding()
                .foregroundColor(Color.gray)
                .border(.purple, width: 4)
            
            Spacer().frame(height:50)
            
            TextEditor(text: $descText)
                .frame(width: .infinity,
                       height: 164,alignment: .topLeading)
                .padding()
                .foregroundColor(Color.gray)
                .border(.purple, width: 4)
            
            Button(action: {
                print("The value of myVariable is: \(titleText) \(descText)")
                            onSaveClicked(titleText, descText)
                        }) {
                            Text("Save")
                                .padding()
                                .background(.purple)
                                .foregroundColor(.white)
                                .cornerRadius(8)
                        }
                        .padding()
                        .frame(width: 160)
            
        })
        .padding(16)
        .frame(maxWidth: .infinity,alignment: .top)
            
    }
}




#Preview {
    EmptyView()
}
