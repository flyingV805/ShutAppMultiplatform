package kz.flyingv.shutapp.auth.ui

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kz.flyingv.shutapp.auth.ui.fragment.ServerFragment
import kz.flyingv.shutapp.auth.ui.fragment.WelcomeFragment
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

        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            userScrollEnabled = false
        ){

            when(uiState.value.stage){
                AuthStage.Welcome -> WelcomeFragment(welcomeDone = { viewModel.reduce(AuthAction.WelcomeDone) })
                AuthStage.Server -> ServerFragment()
            }

        }



    }

}