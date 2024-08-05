package kz.flyingv.shutapp.auth.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIViewModel

class AuthViewModel: UIViewModel<AuthState, AuthAction, AuthEvent>(
    AuthState()
) {

    override fun reduce(action: AuthAction) {
        TODO("Not yet implemented")
    }

}