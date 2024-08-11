package kz.flyingv.shutapp.auth.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIViewModel
import kz.flyingv.shutapp.auth.ui.state.AuthStage

class AuthViewModel: UIViewModel<AuthState, AuthAction, AuthEvent>(
    AuthState()
) {

    override fun reduce(action: AuthAction) {
        when(action){
            AuthAction.WelcomeDone -> {
                val newState = currentState().copy(stage = AuthStage.ServerSelection)
                pushState(newState)
            }
        }
    }

}