package kz.flyingv.shutapp.launch.domain

import kz.flyingv.shutapp.core.MatrixProvider
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class IsLoggedInUseCase: KoinComponent {

    private val _matrix: MatrixProvider by inject()

    suspend operator fun invoke(): Boolean = _matrix.isLoggedIn()

}