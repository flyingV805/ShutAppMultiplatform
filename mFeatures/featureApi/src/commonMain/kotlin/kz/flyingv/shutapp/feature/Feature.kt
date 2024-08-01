package kz.flyingv.shutapp.feature

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

interface Feature {

    fun route(argument: String? = null): String
    @Composable fun screen(navController: NavHostController)

}