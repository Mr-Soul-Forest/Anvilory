/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package forgeofovorldule.anvilory

expect fun saveValue(value: Any, name: String)

fun saveAllValues() {
    saveValue(app_version, "app_version")
    saveValue(language, "language")
    saveValue(plots.size, "plots-size")
    for (x in 0..<plots.size) {
        saveValue(plots[x].title, "plots-$x--title")
        saveValue(plots[x].description, "plots-$x--description")
        saveValue(plots[x].typeOfPlot, "plots-$x--typeOfPlot")
        saveValue(plots[x].lastEdit, "plots-$x--lastEdit")
        saveValue(plots[x].chapters.size, "plots-$x--chapters-size")
        for (y in 0..<plots[x].chapters.size) {
            saveValue(plots[x].chapters[y].title, "plots-$x--chapters-$y--title")
            saveValue(plots[x].chapters[y].lastEdit, "plots-$x--chapters-$y--lastEdit")
            saveValue(plots[x].chapters[y].parts.size, "plots-$x--chapters-$y--parts-size")
            for (z in 0..<plots[x].chapters[y].parts.size) {
                saveValue(plots[x].chapters[y].parts[z].text, "plots-$x--chapters-$y--parts-$z--text")
                saveValue(plots[x].chapters[y].parts[z].lastEdit, "plots-$x--chapters-$y--parts-$z--lastEdit")
            }
        }
    }
}