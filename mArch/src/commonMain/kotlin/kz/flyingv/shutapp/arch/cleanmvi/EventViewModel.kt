package kz.flyingv.shutapp.arch.cleanmvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class EventViewModel<E: UIEvent>: ViewModel() {

    private val _uiEvent = MutableSharedFlow<E>()

    fun provideEvents(): SharedFlow<E> = _uiEvent.asSharedFlow()

    protected suspend fun pushEvent(event: E){
        _uiEvent.emit(event)

    }

}