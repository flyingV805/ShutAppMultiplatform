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

private val featuresModule = module {

    single { FeatureLaunch() } bind Feature::class

    val auth = FeatureAuth()
    single { auth } bind Feature::class
    single( named("auth") ){ auth } //pretty bad solution, but ok for now

}

val appDiModules = listOf(
    coreModule,
    featuresModule
)