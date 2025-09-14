package forgeofovorldule.anvilory

import androidx.compose.ui.graphics.Color

fun averageColor(colors: List<Color>): Color {
    if (colors.isEmpty()) return Color.Black

    val size = colors.size
    var sumRed = 0.0f
    var sumGreen = 0.0f
    var sumBlue = 0.0f
    var sumAlpha = 0.0f
    for (c in colors) {
        sumRed += c.red
        sumGreen += c.green
        sumBlue += c.blue
        sumAlpha += c.alpha
    }

    return Color(
        red = sumRed / size,
        green = sumGreen / size,
        blue = sumBlue / size,
        alpha = sumAlpha / size
    )
}

fun reversColor(color: Color): Color {
    return Color(1f - color.red, 1f - color.green, 1f - color.blue, color.alpha)
}

fun checkBackgroundBright(background: Color, ifDark: Color, ifLight: Color = reversColor(ifDark)): Color {
    return if ((background.red + background.green + background.blue) * 255 < 382.5) ifDark else ifLight
}