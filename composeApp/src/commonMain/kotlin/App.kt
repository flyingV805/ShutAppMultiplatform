import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Colors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kz.flyingv.shutapp.feature.Feature
import kz.flyingv.shutapp.launch.FeatureLaunch
import kz.flyingv.shutapp.uikit.theme.ShutAppTheme
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.mp.KoinPlatform.getKoin

@Composable
@Preview
fun App(
    dynamicColorScheme: Colors? = null
) {

    val navController: NavHostController = rememberNavController()

    val featureLaunch = remember { getKoin().get<FeatureLaunch>() }
    val features = remember { getKoin().getAll<Feature>() }

    ShutAppTheme(
        dynamicColorScheme = dynamicColorScheme
    ) {

        NavHost(
            navController = navController,
            startDestination = featureLaunch.route(),
            modifier = Modifier.fillMaxSize()
        ){

            features.forEach { feature ->
                composable(route = feature.route()){ feature.screen(navController) }
            }

        }


    }

}
