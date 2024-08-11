package kz.flyingv.shutapp.core

interface MatrixProvider {

    suspend fun isLoggedIn(): Boolean

}