package kz.flyingv.shutapp.launch.ui

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.flyingv.shutapp.arch.cleanmvi.EventViewModel
import kz.flyingv.shutapp.launch.domain.IsLoggedInUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchViewModel : EventViewModel<LaunchEvent>(), KoinComponent {

    private val isLoggedIn: IsLoggedInUseCase by inject()

    init {
        viewModelScope.launch {
            if(isLoggedIn()){
                pushEvent(LaunchEvent.ToHome)
            }else{
                pushEvent(LaunchEvent.ToAuth)
            }
        }
    }

}