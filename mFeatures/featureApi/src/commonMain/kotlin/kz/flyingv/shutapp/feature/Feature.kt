package kz.flyingv.shutapp.feature

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import org.koin.core.module.Module
import org.koin.dsl.module

interface Feature {

    val diModule: Module

    fun route(argument: String? = null): String
    @Composable fun screen(navController: NavHostController)

}