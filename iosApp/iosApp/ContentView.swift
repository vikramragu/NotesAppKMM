import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greet()
    
    private let usecaseModule = UseCaseModule()

	var body: some View {
        NotesHome(usecase: usecaseModule.notesUseCase)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
