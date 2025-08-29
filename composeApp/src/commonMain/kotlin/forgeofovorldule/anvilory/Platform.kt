package forgeofovorldule.anvilory

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform