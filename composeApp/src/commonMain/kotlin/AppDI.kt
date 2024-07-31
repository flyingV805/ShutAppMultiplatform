import kz.flyingv.shutapp.auth.FeatureAuth
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.FeatureLaunch
import org.koin.dsl.bind
import org.koin.dsl.module

private val coreModule = module {

}

private val featuresModule = module {
    //declareMultibinding<String, Int>()
    single{ FeatureLaunch() } bind Feature::class
    single{ FeatureAuth() } bind Feature::class
}

val appDiModules = listOf(
    coreModule,
    featuresModule
)