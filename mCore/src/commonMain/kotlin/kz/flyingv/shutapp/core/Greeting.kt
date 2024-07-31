package kz.flyingv.shutapp.core

class Greeting {
    private val platform = ""

    fun greet(): String {
        return "Hello, ${platform}!"
    }
}