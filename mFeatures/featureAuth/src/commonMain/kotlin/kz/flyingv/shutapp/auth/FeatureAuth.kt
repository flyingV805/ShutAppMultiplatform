package kz.flyingv.shutapp.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.auth.ui.AuthView

class FeatureAuth: Feature {

    override fun route(argument: String?): String = "auth"
    @Composable override fun screen(navController: NavHostController) = AuthView()

}