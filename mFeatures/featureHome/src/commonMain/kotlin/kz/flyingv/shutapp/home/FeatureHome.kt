package kz.flyingv.shutapp.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.home.ui.HomeView
import org.koin.dsl.module

class FeatureHome: Feature {

    override val diModule = module { }

    override fun route(argument: String?): String = "home"
    @Composable override fun screen(navController: NavHostController) = HomeView(navController)

}