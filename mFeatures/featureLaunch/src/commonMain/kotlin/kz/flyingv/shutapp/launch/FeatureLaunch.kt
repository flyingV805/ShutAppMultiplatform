package kz.flyingv.shutapp.launch

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.domain.IsLoggedInUseCase
import kz.flyingv.shutapp.launch.ui.LaunchView
import org.koin.dsl.module

class FeatureLaunch: Feature {

    override val diModule = module {
        factory { IsLoggedInUseCase() }
    }

    override fun route(argument: String?): String = "launch"
    @Composable override fun screen(navController: NavHostController) = LaunchView(navController)

}