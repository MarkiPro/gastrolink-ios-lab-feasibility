import SwiftUI
import UIKit
import GastroLinkIOSLab

struct IosLabContentView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        IosEntryKt.GastroLinkIosLabViewController()
    }

    func updateUIViewController(_ viewController: UIViewController, context: Context) {}
}
