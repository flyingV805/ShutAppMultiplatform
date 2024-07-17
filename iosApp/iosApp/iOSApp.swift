import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        AppleDiKt.startKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
