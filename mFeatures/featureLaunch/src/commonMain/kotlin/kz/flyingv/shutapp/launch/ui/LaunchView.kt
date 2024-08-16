package kz.flyingv.shutapp.launch.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.flow.collectLatest

@Composable
internal fun LaunchView(navController: NavHostController, viewModel: LaunchViewModel = viewModel{ LaunchViewModel() }) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){

        Text("LaunchScreen!!!")

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Getting ready to ShutApp...")
                Spacer(modifier = Modifier.height(16.dp))
                LinearProgressIndicator(
                    modifier = Modifier.widthIn(min = 32.dp, max = 300.dp)
                )
            }

        }


        LaunchedEffect(Unit){
            viewModel.provideEvents().collectLatest {
                navController.popBackStack("launch", true)
                when(it){
                    LaunchEvent.ToAuth ->  navController.navigate("auth")
                    LaunchEvent.ToHome -> navController.navigate("home")
                }
            }
        }

    }

}