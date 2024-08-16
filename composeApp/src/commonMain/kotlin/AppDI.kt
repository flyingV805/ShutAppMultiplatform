import kz.flyingv.shutapp.auth.FeatureAuth
import kz.flyingv.shutapp.core.MatrixProvider
import kz.flyingv.shutapp.core.MatrixProviderFactory
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.FeatureLaunch
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

private val coreModule = module {

    single<MatrixProvider> { MatrixProviderFactory.createProvider() }

}

// not so good implementation tbh, need something more secure
private val featuresModule = module {

    // launch
    val launch = FeatureLaunch()
    includes(launch.diModule)
    single { launch } bind Feature::class

    val auth = FeatureAuth()
    includes(auth.diModule)
    single { auth } bind Feature::class
    single( named("auth") ){ auth } //pretty bad solution, but guess ok for now

}

val appDiModules = listOf(
    coreModule,
    featuresModule
)