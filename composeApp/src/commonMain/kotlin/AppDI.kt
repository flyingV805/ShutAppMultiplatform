import org.koin.core.context.startKoin
import org.koin.dsl.module

private val coreModule = module {

}

private val featuresModule = module {
    //declareMultibinding<String, Int>()
}

val appDiModules = listOf(
    coreModule,
    featuresModule
)