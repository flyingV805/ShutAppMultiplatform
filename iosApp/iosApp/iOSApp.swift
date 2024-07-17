import SwiftUI
import composeApp

@main
struct iOSApp: App {

    init() {
        AppKIKt.initAppleDi()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}