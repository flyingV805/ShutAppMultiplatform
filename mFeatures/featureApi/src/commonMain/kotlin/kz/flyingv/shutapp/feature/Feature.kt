package kz.flyingv.shutapp.feature

import androidx.compose.runtime.Composable

interface Feature {

    fun route(argument: String? = null): String
    @Composable fun screen()

}