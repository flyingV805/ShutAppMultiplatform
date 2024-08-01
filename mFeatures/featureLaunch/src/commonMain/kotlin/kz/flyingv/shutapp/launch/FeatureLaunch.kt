package kz.flyingv.shutapp.launch

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.ui.LaunchScreen

class FeatureLaunch: Feature {

    override fun route(argument: String?): String = "launch"
    @Composable override fun screen(navController: NavHostController) = LaunchScreen(navController)

}