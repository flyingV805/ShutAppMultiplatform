package kz.flyingv.shutapp.launch.ui

import kz.flyingv.shutapp.arch.cleanmvi.UIEvent

sealed class LaunchEvent: UIEvent {

    data object ToHome: LaunchEvent()
    data object ToAuth: LaunchEvent()

}