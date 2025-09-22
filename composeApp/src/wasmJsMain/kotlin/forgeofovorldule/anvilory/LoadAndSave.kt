/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package forgeofovorldule.anvilory

import kotlinx.browser.localStorage
import kotlinx.serialization.json.Json

actual fun saveValue(value: Any, name: String) {
    val serialized = when (value) {
        is String -> Json.encodeToString(value)
        is Int -> Json.encodeToString(value)
        is Boolean -> Json.encodeToString(value)
        else -> Json.encodeToString(value.toString())
    }
    localStorage.setItem(name, serialized)
}