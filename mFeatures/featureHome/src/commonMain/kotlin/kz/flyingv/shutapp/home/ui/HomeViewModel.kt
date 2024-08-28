package kz.flyingv.shutapp.home.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIViewModel
import org.koin.core.component.KoinComponent

class HomeViewModel: UIViewModel<HomeState, HomeAction, HomeEvent>(
    HomeState()
), KoinComponent {

    override fun reduce(action: HomeAction) {

    }

}