import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private val coreModule = module {

}

private val featuresModule = module {
    //declareMultibinding<String, Int>()
    single{ FeatureLaunch() } bind Feature::class
}

val appDiModules = listOf(
    coreModule,
    featuresModule
)