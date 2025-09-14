package forgeofovorldule.anvilory

const val app_version = 1000000 //0.1.0.0

enum class AppStatus {
    LOADING,
    PLOTS,
    PLOTS_UPDATER,
    PLOT,
    CHARTER
}

var languages: Languages = Languages.EN

var plots = mutableListOf(Plot())