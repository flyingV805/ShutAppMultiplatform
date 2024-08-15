package kz.flyingv.shutapp.launch.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
internal fun LaunchScreen(navController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ){

        Text("LaunchScreen!!!")

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

            Column {
                Text("Getting ready to ShutApp...")
                LinearProgressIndicator(
                    modifier = Modifier.widthIn(min = 32.dp, max = 300.dp)
                )
            }

        }

        LaunchedEffect(Unit){
            delay(2000)
            navController.popBackStack("launch", true)
            navController.navigate("auth")
        }

    }

}