/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package forgeofovorldule.anvilory

import kotlinx.serialization.json.*
import java.io.File

private val json = Json { prettyPrint = true }
private val settingsFile = File("anvilory-save-by-forge-of-ovorldule.json")

private fun readSettings(): MutableMap<String, JsonElement> {
    if (!settingsFile.exists()) return mutableMapOf()
    val text = settingsFile.readText()
    if (text.isBlank()) return mutableMapOf()
    return json.parseToJsonElement(text).jsonObject.toMutableMap()
}

private fun writeSettings(settings: Map<String, JsonElement>) {
    settingsFile.writeText(json.encodeToString(JsonObject(settings)))
}

actual fun saveValue(value: Any, name: String) {
    val settings = readSettings().toMutableMap()
    val element = when (value) {
        is String -> JsonPrimitive(value)
        is Number -> JsonPrimitive(value)
        is Boolean -> JsonPrimitive(value)
        else -> JsonPrimitive(value.toString()) // fallback: строка
    }
    settings[name] = element
    writeSettings(settings)
}
