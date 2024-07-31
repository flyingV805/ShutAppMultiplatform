import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.alexzhirkevich.compottie.LottieComposition
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.FeatureLaunch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatform.getKoin
import shutapp.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Stable
public suspend fun LottieCompositionSpec.Companion.ResourceString(
    path : String,
    dir : String = "files",
    readBytes: suspend (path: String) -> ByteArray = { Res.readBytes(it) }
) : LottieCompositionSpec =
    LottieCompositionSpec.JsonString(readBytes("$dir/$path").decodeToString())

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {

    //val featureLaunch = remember { FeatureLaunch() }
    val navController: NavHostController = rememberNavController()

    val featureLaunch = remember { getKoin().get<FeatureLaunch>() }
    val features = remember { getKoin().getAll<Feature>() }

    MaterialTheme {

        NavHost(
            navController = navController,
            startDestination = featureLaunch.route(),
            modifier = Modifier.fillMaxSize()
        ){

            features.forEach { feature ->
                composable(route = feature.route()){ feature.screen() }
            }

        }

        val lottieString = mutableStateOf<String?>(null)
        var shouldDraw by remember { mutableStateOf(false) }

        LaunchedEffect(true) {
            lottieString.value = Res.readBytes("files/faceValidationWarning.json").decodeToString()
            shouldDraw = true
        }

        if(shouldDraw){
            val composition by rememberLottieComposition(
                LottieCompositionSpec.JsonString(
                    lottieString.value!!
                )
            )

            Image(
                modifier = Modifier.width(200.dp).height(200.dp).background(Color.Blue),
                painter = rememberLottiePainter(
                    composition = composition
                ),
                contentDescription = "Lottie animation"
            )
        }

        Text("dsfsdfsdfsdf")

        /*var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
    }

}
