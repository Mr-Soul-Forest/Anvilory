/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

import android.content.Context
import android.preference.PreferenceManager
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

lateinit var appContext: Context

actual fun saveValue(value: Any, name: String) {
    val prefs = PreferenceManager.getDefaultSharedPreferences(appContext)
    val serialized = when (value) {
        is String -> Json.encodeToString(value)
        is Int -> Json.encodeToString(value)
        is Boolean -> Json.encodeToString(value)
        else -> Json.encodeToString(value.toString())
    }
    prefs.edit().putString(name, serialized).apply()
}
