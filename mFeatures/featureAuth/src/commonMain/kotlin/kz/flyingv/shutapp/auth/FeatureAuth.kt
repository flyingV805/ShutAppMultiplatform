package kz.flyingv.shutapp.auth

import androidx.compose.runtime.Composable
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.auth.ui.AuthScreen

class FeatureAuth: Feature {

    override fun route(argument: String?): String = "auth"
    @Composable override fun screen() = AuthScreen()

}