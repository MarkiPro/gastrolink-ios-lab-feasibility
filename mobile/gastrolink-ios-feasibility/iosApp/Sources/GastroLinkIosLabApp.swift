import SwiftUI

@main
struct GastroLinkIosLabApp: App {
    var body: some Scene {
        WindowGroup {
            // The Lab starts in the FP-01A dark appearance. Match the host
            // safe areas and system chrome to that initial shared surface.
            // Dynamic light-mode synchronization still needs its own bridge.
            IosLabContentView()
                .background(
                    Color(
                        red: 7.0 / 255.0,
                        green: 16.0 / 255.0,
                        blue: 25.0 / 255.0
                    ).ignoresSafeArea()
                )
                .preferredColorScheme(.dark)
        }
    }
}
