package forgeofovorldule.anvilory

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppViewModel {
    private val _appStatus = MutableStateFlow(AppStatus.LOADING)
    val appStatus: StateFlow<AppStatus> = _appStatus

    fun setStatus(status: AppStatus) {
        _appStatus.value = status
    }
}