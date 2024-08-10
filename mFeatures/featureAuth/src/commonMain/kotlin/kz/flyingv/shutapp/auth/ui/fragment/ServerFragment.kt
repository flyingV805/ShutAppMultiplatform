package kz.flyingv.shutapp.auth.ui.fragment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.github.alexzhirkevich.compottie.LottieAnimation
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.LottieConstants
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import kz.flyingv.shutapp.uikit.composable.ShutAppButton
import org.jetbrains.compose.resources.ExperimentalResourceApi
import shutapp.mfeatures.featureauth.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ServerFragment(){

    var compositionString by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(Unit){ compositionString = Res.readBytes("files/server.json").decodeToString() }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        if(compositionString != null){

            val composition by rememberLottieComposition( LottieCompositionSpec.JsonString(compositionString!!) )

            LottieAnimation(
                composition = composition,
                modifier = Modifier.weight(1f),
                iterations = LottieConstants.IterateForever,
            )

        }

        Text(
            text = "Pick a Matrix Server!",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Fast, simple and open client for Matrix.\nHigh-end Encryption.\nNo, and there will be no collection of personal data.",
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        ShutAppButton(
            buttonText = "Let's start!",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

    }

}