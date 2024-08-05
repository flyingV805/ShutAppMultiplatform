package kz.flyingv.shutapp.auth.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIState
import kz.flyingv.shutapp.auth.ui.state.AuthStage

data class AuthState(
    val stage: AuthStage = AuthStage.Welcome
): UIState