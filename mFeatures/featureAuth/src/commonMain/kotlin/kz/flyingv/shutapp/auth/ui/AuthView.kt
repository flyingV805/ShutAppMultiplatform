package kz.flyingv.shutapp.auth.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.flyingv.shutapp.auth.ui.fragment.Login
import kz.flyingv.shutapp.auth.ui.fragment.Registration
import kz.flyingv.shutapp.auth.ui.fragment.ServerCapabilities
import kz.flyingv.shutapp.auth.ui.fragment.ServerSelection
import kz.flyingv.shutapp.auth.ui.fragment.Welcome
import kz.flyingv.shutapp.auth.ui.state.AuthStage
import kz.flyingv.shutapp.uikit.decoration.accentGradient
import kz.flyingv.shutapp.uikit.decoration.welcomeGradientAccent
import kz.flyingv.shutapp.uikit.decoration.welcomeGradientPrimary

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun AuthView(viewModel: AuthViewModel = viewModel{ AuthViewModel() }) {

    val pagerState = rememberPagerState { AuthStage.entries.size }

    val uiState = viewModel.provideState().collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){

        Crossfade(
            targetState = uiState.value.stage,
            label = "",
            animationSpec = tween(durationMillis = 500)
        ){
            when(it){
                AuthStage.Welcome -> Box(modifier = Modifier.fillMaxSize().background(welcomeGradientPrimary))
                AuthStage.ServerSelection -> Box(
                    modifier = Modifier.fillMaxSize().background(welcomeGradientAccent),
                    contentAlignment = Alignment.TopEnd
                ){
                    Box(modifier = Modifier.height(300.dp).width(300.dp).background(accentGradient))
                }

                AuthStage.ServerCapabilities -> TODO()
                AuthStage.Registration -> TODO()
                AuthStage.Login -> TODO()
            }
        }

        Text("AuthScreen!!!")

        Crossfade(
            modifier = Modifier.fillMaxSize(),
            targetState = pagerState,
            animationSpec = tween(durationMillis = 250)
        ){

            when(uiState.value.stage){
                AuthStage.Welcome -> Welcome(welcomeDone = { viewModel.reduce(AuthAction.WelcomeDone) })
                AuthStage.ServerSelection -> ServerSelection()
                AuthStage.ServerCapabilities -> ServerCapabilities()
                AuthStage.Registration -> Registration()
                AuthStage.Login -> Login()
            }

        }



    }

}