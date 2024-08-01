package kz.flyingv.shutapp.auth.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kz.flyingv.shutapp.uikit.decoration.accentGradient
import kz.flyingv.shutapp.uikit.decoration.welcomeGradientAccent
import kz.flyingv.shutapp.uikit.decoration.welcomeGradientPrimary

@Composable
internal fun AuthScreen() {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){

        Crossfade(
            targetState = 1,
            label = "",
            animationSpec = tween(durationMillis = 500)
        ){
            when(it){
                1 -> Box(modifier = Modifier.fillMaxSize().background(welcomeGradientPrimary))
                else -> Box(
                    modifier = Modifier.fillMaxSize().background(welcomeGradientAccent),
                    contentAlignment = Alignment.TopEnd
                ){
                    Box(modifier = Modifier.height(300.dp).width(300.dp).background(accentGradient))
                }
            }
        }
        Text("AuthScreen!!!")


    }

}