package kz.flyingv.shutapp.home.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIState

data class HomeState(
    val loading: Boolean = false
): UIState
