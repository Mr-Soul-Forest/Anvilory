/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

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