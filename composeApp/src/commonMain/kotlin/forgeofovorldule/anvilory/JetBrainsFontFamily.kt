package forgeofovorldule.anvilory

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import anvilory.composeapp.generated.resources.JetBrainsMono_Bold
import anvilory.composeapp.generated.resources.JetBrainsMono_Bold_Italic
import anvilory.composeapp.generated.resources.JetBrainsMono_ExtraBold
import anvilory.composeapp.generated.resources.JetBrainsMono_ExtraBold_Italic
import anvilory.composeapp.generated.resources.JetBrainsMono_Italic
import anvilory.composeapp.generated.resources.JetBrainsMono_Medium
import anvilory.composeapp.generated.resources.JetBrainsMono_Medium_Italic
import anvilory.composeapp.generated.resources.JetBrainsMono_Regular
import anvilory.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun JetBrainsFont(): FontFamily {
    return FontFamily(
        Font(Res.font.JetBrainsMono_ExtraBold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(Res.font.JetBrainsMono_Italic, FontWeight.Normal, FontStyle.Italic),
        Font(Res.font.JetBrainsMono_Medium, FontWeight.Medium, FontStyle.Normal),
        Font(Res.font.JetBrainsMono_Bold, FontWeight.Bold, FontStyle.Normal),
        Font(Res.font.JetBrainsMono_Regular, FontWeight.Normal, FontStyle.Normal),
        Font(Res.font.JetBrainsMono_Bold_Italic, FontWeight.Bold, FontStyle.Italic),
        Font(Res.font.JetBrainsMono_ExtraBold_Italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(Res.font.JetBrainsMono_Medium_Italic, FontWeight.Normal, FontStyle.Italic)
    )
}