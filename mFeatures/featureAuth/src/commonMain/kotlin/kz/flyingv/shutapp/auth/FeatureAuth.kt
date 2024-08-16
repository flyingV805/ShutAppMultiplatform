package kz.flyingv.shutapp.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.auth.ui.AuthView
import org.koin.dsl.module

class FeatureAuth() : Feature {

    override val diModule = module { }

    override fun route(argument: String?): String = "auth"
    @Composable override fun screen(navController: NavHostController) = AuthView()

}