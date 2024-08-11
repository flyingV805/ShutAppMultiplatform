package kz.flyingv.shutapp.core

class MatrixProviderFactory {

    companion object {

        fun createProvider(): MatrixProvider = MatrixProviderTrixnity()

    }

}