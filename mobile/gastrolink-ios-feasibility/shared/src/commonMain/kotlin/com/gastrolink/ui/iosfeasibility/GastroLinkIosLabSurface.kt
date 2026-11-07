package com.gastrolink.ui.iosfeasibility

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * UI Lab-only proof of one portable Compose presentation surface.
 * Palette values come from FP-01A / the existing Android reference tokens.
 * This is NOT a production GStatusChip, a replacement design context, or a
 * settings owner. Any extraction must await visual/device acceptance.
 */
@Composable
fun GastroLinkIosLabSurface() {
    var dark by remember { mutableStateOf(true) }
    var highContrast by remember { mutableStateOf(false) }
    var bosnian by remember { mutableStateOf(false) }
    val background = if (dark) Color(0xFF071019) else Color(0xFFF4F7FA)
    val surface = if (dark) Color(0xFF0B1722) else Color(0xFFFFFFFF)
    val foreground = if (dark) Color(0xFFF4F9FC) else Color(0xFF10202D)
    val secondary = if (dark) Color(0xFFA9C0CF) else Color(0xFF536675)
    val outline = when {
        highContrast && dark -> Color(0xFFD5E9F4)
        highContrast -> Color(0xFF243642)
        dark -> Color(0xFF46687D)
        else -> Color(0xFFAABAC5)
    }
    val warning = Color(0xFFE6A23C)

    Column(
        modifier = Modifier.fillMaxSize().background(background)
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "GastroLink iOS UI Lab",
            color = foreground,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Isolated feasibility • synthetic data • no venue actions",
            color = secondary,
            fontSize = 13.sp,
        )
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(surface, RoundedCornerShape(14.dp))
                .border(1.dp, outline, RoundedCornerShape(14.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                if (bosnian) "Pregled stanja" else "Status presentation sample",
                color = foreground,
                fontSize = 18.sp,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Box(
                    modifier = Modifier.size(12.dp)
                        .background(warning, RoundedCornerShape(6.dp)),
                )
                // The semantic hue is a non-text cue. Text remains readable
                // in both appearances and with high contrast enabled.
                Text(
                    if (bosnian) "U redu čekanja bez mreže" else "Queued offline",
                    modifier = Modifier.semantics {
                        contentDescription = if (bosnian)
                            "U redu čekanja bez mreže" else "Queued offline"
                    },
                    color = foreground,
                    fontSize = 14.sp,
                )
            }
        }
        LabToggle(
            label = if (dark) "Appearance: dark" else "Appearance: light",
            foreground = foreground,
            outline = outline,
            onClick = { dark = !dark },
        )
        LabToggle(
            label = if (highContrast) "High contrast: on" else "High contrast: off",
            foreground = foreground,
            outline = outline,
            onClick = { highContrast = !highContrast },
        )
        LabToggle(
            label = if (bosnian) "Language: Bosnian" else "Language: English",
            foreground = foreground,
            outline = outline,
            onClick = { bosnian = !bosnian },
        )
    }
}

// Lab-only interaction; deliberately not exported as a competing GButton.
@Composable
private fun LabToggle(
    label: String,
    foreground: Color,
    outline: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth().heightIn(min = 48.dp)
            .border(1.dp, outline, RoundedCornerShape(10.dp))
            .clickable(role = Role.Button, onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 12.dp),
        contentAlignment = Alignment.CenterStart,
    ) {
        Text(text = label, color = foreground, fontSize = 14.sp)
    }
}
