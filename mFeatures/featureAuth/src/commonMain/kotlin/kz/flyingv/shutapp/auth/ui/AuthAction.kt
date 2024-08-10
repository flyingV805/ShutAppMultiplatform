package kz.flyingv.shutapp.auth.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIAction

sealed class AuthAction: UIAction {

    data object WelcomeDone: AuthAction()

}