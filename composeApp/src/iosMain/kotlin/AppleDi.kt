import org.koin.core.context.startKoin

@Suppress("unused")
fun startKoin(){
    startKoin {
        modules(appDiModules)
    }
}