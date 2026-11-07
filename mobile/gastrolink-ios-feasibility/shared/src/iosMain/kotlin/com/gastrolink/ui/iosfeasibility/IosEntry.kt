package com.gastrolink.ui.iosfeasibility

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

/** iOS Lab entry only. No Pocket/Flow or real venue operations. */
fun GastroLinkIosLabViewController(): UIViewController = ComposeUIViewController {
    GastroLinkIosLabSurface()
}
