/**Copyright 2025 Forge-of-Ovorldule (https://github.com/Forge-of-Ovorldule) and Mr-Soul-Forest (https://github.com/Mr-Soul-Forest)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 */

package forgeofovorldule.anvilory

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: AppViewModel) {
    val appStatus by viewModel.appStatus.collectAsState()

    when (appStatus) {
        AppStatus.LOADING -> LoadingContent(viewModel)
        AppStatus.PLOTS -> PlotsContent(viewModel)
        AppStatus.PLOTS_UPDATER -> {
            PlotsContent(viewModel)
            LaunchedEffect(Unit) {
                viewModel.setStatus(AppStatus.PLOTS)
            }
        }

        AppStatus.CHARTERS -> ChaptersContent(viewModel)

        else -> PlotsContent(viewModel)
    }
}