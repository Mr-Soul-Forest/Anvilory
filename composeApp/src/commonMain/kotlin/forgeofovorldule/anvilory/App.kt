package forgeofovorldule.anvilory

import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: AppViewModel) {
    val appStatus by viewModel.appStatus.collectAsState()

    when (appStatus) {
        AppStatus.LOADING -> LoadingContent(viewModel)
        else -> LoadingContent(viewModel)
    }
}