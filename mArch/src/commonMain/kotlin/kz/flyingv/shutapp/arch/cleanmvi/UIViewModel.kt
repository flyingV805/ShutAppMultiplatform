package kz.flyingv.shutapp.arch.cleanmvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class UIViewModel<S: UIState, in A: UIAction, E: UIEvent>(
    initialState: S
): ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    private val _uiEvent = MutableSharedFlow<E>()

    fun provideState(): StateFlow<S> = _uiState.asStateFlow()
    fun provideEvents(): SharedFlow<E> = _uiEvent.asSharedFlow()

    protected fun currentState(): S = _uiState.value

    protected fun pushState(newState: S){
        _uiState.update { newState }
    }

    protected suspend fun pushEvent(event: E){
        _uiEvent.emit(event)
    }

    abstract fun reduce(action: A)

}